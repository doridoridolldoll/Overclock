package overclock.overclock.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import overclock.overclock.entity.Posts;
import overclock.overclock.entity.QMember;
import overclock.overclock.entity.QPosts;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

@Log4j2
public class SearchPostsRepositoryImpl extends QuerydslRepositorySupport implements SearchPostsRepository {

    public SearchPostsRepositoryImpl() {
        super(Posts.class);
    }

    @Override
    public Posts search1() {
        QPosts posts = QPosts.posts;
        QMember member = QMember.member;

        JPQLQuery<Posts> jpqlQuery = from(posts);
        jpqlQuery.leftJoin(member).on(posts.id.eq(member.id));
        // Tuple : 동적인 query에 대하여 복합 데이터를 추출하는 경우에 사용
        // Tuple : Used when extracting complex data for a dynamic query
        JPQLQuery<Tuple> jpqlQueryTuple=jpqlQuery.select(posts,member.email);
        jpqlQueryTuple.groupBy(posts);

        List<Tuple> result = jpqlQueryTuple.fetch();
        return null;
    }

    @Override
    public Page<Object[]> searchPage(String type, String keyword, Pageable pageable) {
        log.info("searchPage............");
        // 1) 질의하고자 하는 Entity 를 QDomain으로 불러온다.
        // 1) Import the Entity you want to query into QDomain.
        QPosts posts = QPosts.posts;

        QMember member = QMember.member;

        //2) Join with QDomain
        //검색을 하기 위한 JPQLQuery가 만들어짐(JPQLQuery is created to do the search.)
        JPQLQuery<Posts> jpqlQuery = from(posts);
        jpqlQuery.leftJoin(member).on(posts.id.eq(member.id));

        //3) JPQLQuery가 가져오고 싶은 데이터를 선택함
        // JPQLQuery selects the data you want to fetch
        // Tuple : 동적인 query에 대하여 복합 데이터를 추출하는 경우에 사용
        // Tuple : Used when extracting complex data for a dynamic query
        JPQLQuery<Tuple> jpqlQueryTuple = jpqlQuery.select(posts, member);

        //4) 기본 검색조건 더하기
        //4) Add Basic search criteria
        BooleanBuilder builder = new BooleanBuilder();
        BooleanExpression expression = posts.id.gt(0L);
        builder.and(expression);

        //5) 추가 검색조건 더하기
        //5) Add additional search criteria
        if(type != null){
            String[] typeArr = type.split("");
            BooleanBuilder conditionBuilder = new BooleanBuilder();
            for(String t : typeArr){
                switch(t) {
                    case "t":
                        conditionBuilder.or(posts.title.contains(keyword)); break;
                    case "c":
                        conditionBuilder.or(posts.content.contains(keyword)); break;
                    case "w":
                        conditionBuilder.or(member.email.contains(keyword)); break;
                }
            }
            builder.and(conditionBuilder);//조건빌더와 기본빌더를 합침.
        }
        jpqlQueryTuple.where(builder); //jpqlQueryTuple에 조건절을 붙임.

        //정렬
        Sort sort = pageable.getSort();
        //매개변수 pageable로부터 정렬을 파악.
        //Determine the alignment from the parameter pageable. v
        sort.stream().forEach(new Consumer<Sort.Order>() {
            @Override
            public void accept(Sort.Order order) {
                Order direction = order.isAscending()?Order.ASC:Order.DESC;
                String prop = order.getProperty(); //bno
                //정렬기준을 가지고 있는 객체
                PathBuilder pathBuilder = new PathBuilder<>(Posts.class, "posts");
                jpqlQueryTuple.orderBy(new OrderSpecifier<>(direction, pathBuilder.get(prop)));
            }
        });

        //정렬 후 그룹핑.
        jpqlQueryTuple.groupBy(posts);

        //paging
        jpqlQueryTuple.offset(pageable.getOffset()); //which page
        jpqlQueryTuple.limit(pageable.getPageSize()); //size on a page

        List<Tuple> result = jpqlQueryTuple.fetch(); //검색한 목록
        log.info(result);
        long count = jpqlQueryTuple.fetchCount(); //검색한 갯수
        log.info("COUNT:" + count);

        //Page 인터페이스를 구현한 PageImpl
        //PageImpl implementing the Page interface
        return new PageImpl<Object[]>(
                // result.stream().map(t -> t.toArray()).collect(Collectors.toList()),
                result.stream().map(new Function<Tuple,Object[]>() {
                    @Override
                    public Object[] apply(Tuple t) {
                        return t.toArray();
                    }
                }).collect(Collectors.toList())
                ,pageable, count
        );
    }

}

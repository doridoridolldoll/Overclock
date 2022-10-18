<template>
    <ul>
        <li><strong>상품명 </strong>: {{state.dtoList.title}}</li>
        <li><strong>판매자</strong>: {{state.companyName}} </li>
        <!-- <li><strong>등록일자</strong>: {{state.regDate}}</li> -->
        <li>
            <strong>가격</strong>: {{state.dtoList.price}}
        </li>
        <li><strong>조회수</strong> : {{state.dtoList.view}}</li>
      
    </ul>
</template>

<script>
import { reactive } from '@vue/reactivity';
import store from '@/store';
import axios from 'axios';

  export default {
      name: 'PeriDetail2',
      props: ["dtoList","periDetailId"],
      setup(props){
        const state = reactive({
            dtoList: props.dtoList,
            price : store.state.price,
            postsId : props.periDetailId,
            postsMemberId: "",
            companyName : "",
        });
        console.log(state.dtoList)
        console.log(state.postsId)
        

        // 작성자 가져오기
        const body2 = {
            id: state.postsId,
        }
        const headers = {
          "Content-Type": "application/json"
        };

        axios.post("/api/DetailName", body2, { headers }).then(function(res){
          console.log("================");
          console.log(res.data);
          state.companyName = res.data;
        })
        return {state}
      }
  }

</script>
<style>

</style>
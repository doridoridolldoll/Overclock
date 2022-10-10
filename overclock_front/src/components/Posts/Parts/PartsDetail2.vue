<template>
    <ul>
        <li><strong>상품명 </strong>: {{state.dtoList.title}}</li>
        <li><strong>판매자</strong>: {{state.companyName}} </li>
        <!-- <li><strong>등록일자</strong>: {{state.regDate}}</li> -->
        <li>
            <strong>가격</strong>: {{state.price}}
        </li>
        <li><strong>조회수</strong> : {{state.dtoList.viewCount}}</li>
      
    </ul>
</template>

<script>
import { reactive } from '@vue/reactivity';
import store from '@/store';
import axios from 'axios';

  export default {
      name: 'PartsDetail2',
      props: ["dtoList","id"],
      setup(props){
        const state = reactive({
            dtoList: props.dtoList,
            price : store.state.price,
            id: props.id,
            companyName : "",
        });
        console.log(state.dtoList)
        console.log(state.id)
        

        // 작성자 가져오기
        const body2 = {
            id: state.id,
        }
        const headers = {
          "Content-Type": "application/json"
        };

        axios.post("/api/DetailName", body2, { headers }).then(function(res){
          
          console.log(res);
          console.log("============");
          state.companyName = res.data;
        //   var str = res.data.regDate;
        //   state.regDate = str.substring(0,str.indexOf('T'));
        })
        return {state}
      }
  }

</script>
<style>

</style>
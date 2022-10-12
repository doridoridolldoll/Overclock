<template>
  <div class="comment form-floating">
    <h5 class="hh3 mt-2">댓글</h5>

    <textarea name="comment" id="comment" cols="80" rows="3" v-model="state.content" ref="commentcontext" placeholder="댓글을 입력하세요"></textarea>
    <button class="btn bbtn btn-primary pull-right my-2" type="button" @click="addNewcomment">등록</button> 
  </div>
  <Card
    :postsId="state.postsId"
  />  

  <!-- <hr />
    <div class="comment-area d-flex flex-column align-items-between">
        <CommentCard v-for="info in commentState" v-bind:key="info" v-bind:cardInfo="info"></CommentCard>
        <button class="btn btn-primary w-100"  @click="getMoreComment" v-if="!(stateInfo[stateInfo.length - 1] == -999||stateInfo[stateInfo.length -1]==0)">댓글 더 보기</button>
    </div> -->
</template>

<script>
// import store from "@/store";
  import {reactive } from "vue"
  import Card from '@/components/Posts/Comment/Card.vue';
  // import { useRouter } from "vue-router"
  import axios from "axios"
import router from '@/router';
import store from '@/store';
  // import CommentCard from "@/comment/Posts/CommentCard.vue"
export default {
    name: "ToPeriComment",
    props: ['dtoList','memberId'],
     components: { Card },
    setup(props) {
      const state = reactive({
        // commentId: ,
        content: '',
        postsId: props.dtoList.id,
        memberId: store.state.id,
      })
 
      const addNewcomment = async() => {
        if(store.state.id == 0 ){
          alert("로그인 후 이용 가능합니다.")
          return;
        }
        const url = "/api/comment/add";
        const headers = {
          "Content-Type": "application/json; charset=utf-8"
        };
        console.log(state.postsId);
        console.log(state.memberId);
        
        let body = {
            memberId: state.memberId,
            postsId  : state.postsId,
            content: state.content,
        };
        axios.post(url, body, { headers }).then((res) => {
          console.log(res);
         })
        async function routing(){
          await router.push(`/PeriDetail?id=${state.postsId}`)  
          await router.go(0)
        }
        routing();
      }


    return{addNewcomment,state}
  },
    // components: { CommentCard }
}
</script>

<style scoped>
.comment{
  margin-top: 30px;

  background: #fff;
  height: 125px;

  border: 1px solid rgb(226, 218, 218);


  -webkit-border-radius: 10px;
  -moz-border-radius: 10px;
  border-radius: 10px;

}
#comment{
  margin-left: 40px;
  margin-top: 20px;
  border-radius: 10px;
}
.hh3{
  float: left;
  margin-left: 45px;
  line-height: 100px;
}
.bbtn{
  margin-bottom: 45px;
  margin-left: 15px;
}


</style>

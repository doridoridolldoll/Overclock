<template>

  <div class="comment" v-for="list in state.dtoList" :key="list"
          >
      <div class="commentId mt-3">
        <span class="commentMember">{{list.id}}</span>
      </div>
      <div class="commentContent mt-3">
        <span class="commentText mt-1">{{list.content}}</span>
      </div>
    </div>
</template>

<script>
import {reactive } from "vue"
import axios from 'axios';
export default {
  
    name:'ToCard',
    props: ["memberId","postsId"],
    setup(props){
      const state = reactive({
        id : null,
        content: null,
        dtoList: null,
        postsId: props.postsId,
        memberId: props.memberId,
      })
  
      let body = {
          postsId: state.postsId,
          memberId: state.memberId
      };
          console.log(state.memberId);
          console.log(state.postsId);
      const url = "/api/comment/list";
      const headers = {
        "Content-Type": "application/json; charset=utf-8"
      };
      
      axios.post(url, body, { headers }).then(function (res) {
        state.dtoList = res.data.dtoList;
        console.log(state.dtoList); 
        for (let i = 0; i < res.data.dtoList.length; i++) {
          state.id = res.data.dtoList[i].id;
          state.content = res.data.dtoList[i].content;
        }
      });
      return {state}
    }

}
</script>

<style scoped>
  .comment{
  margin-top: 30px;

  background: #fff;

  -webkit-border-radius: 10px;
  -moz-border-radius: 10px;
  border-radius: 10px;

}

.commentGr{
  margin-top: 15px;
}

.commentId{
  width: 100px;
  height: 100px;
  float: left;
  line-height: 100px;
}

.commentMember{
  float: right;
  margin-right: 10px;
}

.commentContent{
  width: 700px;
  height: 100px;
  float: left;
  border: 1px solid rgb(226, 218, 218);
}

.commentText{
  float: left;
}



</style>
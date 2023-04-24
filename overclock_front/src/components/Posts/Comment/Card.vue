<template>

  <div class="comment" v-for="(list,i) in state.dtoList" :key="(list,i)">

      <div class="commentId">
        <span class="commentMember">{{state.name[i]}}</span>
      </div>
      <div class="commentContent">

        <span class="commentText mt-1">{{list.content}}</span>
        <!-- <div>{{list}}</div> -->
      </div>
      <a class="btn btn-info mt-2" v-if="list.memberId == $store.state.id" :href="'./CommentModify?id=' + list.id" >수정</a>
    </div>  
</template>

<script>
import {reactive } from "vue"
import axios from 'axios';
export default {
  
    name:'ToCard',
    props: ["postsId"],
    setup(props){

      const state = reactive({
        id : null,
        content: null,
        dtoList: null,
        name : [],
        postsId: props.postsId,
        memberId : "", 
      })
      

      let body = {
          postsId: state.postsId,
      };
      const url = "./api/comment/list";
      const headers = {
        "Content-Type": "application/json; charset=utf-8"
      };
      

      axios.post(url, body, { headers }).then(function (res) {
        state.dtoList = res.data.dtoList;

        //댓글 작성자 추출(과부화 위험 있음)
        for (let i = 0; i < res.data.dtoList.length; i++) {
          state.id = res.data.dtoList[i].id;
          state.memberId = res.data.dtoList[i].memberId
          state.content = res.data.dtoList[i].content;
            axios.post("./api/comment/name", {memberId: state.memberId}, { headers }).then(function (res) {
              state.name[i] = res.data;
            });
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
  width: 140px;
  height: 100px;
  float: left;
  line-height: 100px;
  border: 1px solid rgb(226, 218, 218);
  border-start-start-radius: 10px;
  border-bottom-left-radius: 10px;
  text-align: center;
}

.commentMember{
  margin-right: 10px;
}

.commentContent{
  width: 650px;
  height: 100px;
  float: left;
  border: 1px solid rgb(226, 218, 218);
  border-top-right-radius: 10px;
  border-bottom-right-radius: 10px;
}

.commentText{
  float: left;
  margin-left: 15px;
}

.btn-info{}


</style>
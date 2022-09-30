<template>
  <div class="comment form-floating">
    <h5 class="hh3 mt-2">댓글</h5>
    <textarea name="comment" id="comment" cols="80" rows="3" ref="commentcontext" placeholder="댓글을 입력하세요"></textarea>
    <button class="btn bbtn btn-primary pull-right my-2" type="button" @click="addNewcomment">등록</button> 
  </div>
  <Card/>
  <!-- <hr />
    <div class="comment-area d-flex flex-column align-items-between">
        <CommentCard v-for="info in commentState" v-bind:key="info" v-bind:cardInfo="info"></CommentCard>
        <button class="btn btn-primary w-100"  @click="getMoreComment" v-if="!(stateInfo[stateInfo.length - 1] == -999||stateInfo[stateInfo.length -1]==0)">댓글 더 보기</button>
    </div> -->
</template>

<script>
import Card from './Card.vue';
  // import { ref, reactive } from "vue"
  // import { useRouter } from "vue-router"
  // import { useStore } from 'vuex'
  // import axios from "axios"
  // import CommentCard from "./CommentCard.vue"
export default {
    name: "ToComment",
    setup() {
        // const store = useStore();
        // const router = useRouter();
        // const id = new URLSearchParams(window.location.search).get("article");
        // const headers = {
        //     "Authorization": store.state.token,
        //     "userid": store.state.id
        // };
        // let commentcontext = ref(null);
        // let commentState = reactive([]);
        // let stateInfo = reactive([0]);
        // let commentInfo = reactive({
        //     aid: id,
        //     reqPage: 0,
        //     userid: store.state.id,
        // });
        // function getMoreComment() {
        //     commentInfo.reqPage += 1;
        //     getComments();
        // }
        // function updateStates(cState, sInfo) {
        //     commentState.push(...cState);
        //     stateInfo.push(sInfo);
        // }
        // function getComments() {
        //     axios
        //         .post(store.state.id == 0 ? `${store.state.axiosLink}/article/comment/` : `${store.state.axiosLink}/api/article/comment/`, commentInfo, { headers })
        //         .then(function (res) {
        //         if (res.data.pageTotalCount == commentInfo.reqPage + 1) {
        //             updateStates(res.data.commentList, -999);
        //         }
        //         else {
        //             updateStates(res.data.commentList, (res.data.commentList.length));
        //         }
        //     })
        //         .catch(function () {
        //     });
        // }
        // async function addNewcomment() {
        //     let body = {
        //         userid: store.state.id,
        //         email: store.state.email,
        //         aid: id,
        //         commentContext: commentcontext.value.value,
        //     };
        //     axios
        //         .post(store.state.axiosLink + "/api/article/comment/add/", body, { headers })
        //         .then((res) => {
        //         if (res.data == -1) {
        //             alert("등록되었습니다");
        //             router.go(0);
        //         }
        //         else {
        //             alert("이미 리뷰를 등록하였습니다");
        //             router.go(0);
        //         }
        //     })
        //         .catch((e) => console.log(e));
        //       }
        // return{getComments,getMoreComment, addNewcomment}
    },
    components: { Card }
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

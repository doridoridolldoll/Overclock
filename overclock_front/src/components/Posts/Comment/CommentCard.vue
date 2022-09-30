<template>
    <div class="comment-section d-flex justify-content-between me-4" :style="'margin-left:' + props.cardInfo.commnetDepth * 3 + 'rem'">

        
        <div class="comment-section-right w-90">
            <div class="comment-section-right-commentauthor d-flex justify-content-between">
                <div class="comment-section-right-commentauthor-authorinfo d-flex flex-column gap-1">
                    <div class="comment-section-right-commentauthor-authorinfo_usernamdandregdate d-flex align-items-end gap-1">
                        <span class="comment-section-right-commentauthor-authorinfo_member_id" style="cursor: pointer;" data-bs-toggle="modal" :data-bs-target="+props.cardInfo.cid">{{ props.cardInfo.member_id }}</span>
                        <span class="comment-section-right-commentauthor-authorinfo_regdate" style="font-size: 0.7rem; color: gray">{{ getTimeFromJavaDateForComment(props.cardInfo.regDate) }}</span>
                    </div>

                    <span class="comment-section-right-commentauthor-authorinfo_context">{{ props.cardInfo.commentContext }}</span>
                </div>
            </div>
        </div>
    </div>
    <hr />
</template>
<script>
    // import { defineProps } from "vue";
    // import { useRouter } from "vue-router";
    // import { useStore } from "vuex";
    // import axios from "axios";
    // export default{
    //     name:"ToCard",
    //     setup(){
    // let props = defineProps(["cardInfo"]);
    // const router = useRouter();
    // const store = useStore();
    // const headers = {
    //     "Content-Type": "application/json; charset=utf-8",
    //     Authorization: store.state.token,
    //     userid: store.state.userid,
    // };
    // function remove(num){
    //     axios.post(store.state.axiosLink+"/api/article/comment/remove", {cid:num, userid:store.state.userid}, { headers })
    //     router.go(0)
    // }
    // async function addCommentReply() {
    //     const headers = {
    //         "Content-Type": "application/json; charset=utf-8",
    //         Authorization: store.state.token,
    //         userid: store.state.userid,
    //     };
    //     let body = {
    //         email: store.state.email,
    //         aid: new URLSearchParams(window.location.search).get("article"),
    //         commentGroup: props.cardInfo.commentGroup,
    //         commnetDepth: props.cardInfo.commnetDepth + 1,
    //         commentSorts: props.cardInfo.commentSorts + 1,
    //     };
    //     await axios
    //         .post(store.state.axiosLink+"/api/article/comment/add/reply", body, { headers })
    //         .then((res) => console.log("대댓들어간다아아아", res))
    //         .catch((e) => console.log(e));
    //     router.go(0);
    // }
    // function getTimeFromJavaDateForComment(s) {
    //     const cont = new Date(s);
    //     let date = new Date();
    //     let calculated = (new Date(date.getTime()) - cont) / 1000;
    //     if (calculated < 60) {
    //         return "방금 전";
    //     } else if (calculated < 60 * 60) {
    //         return `${Math.round(calculated / 60)}분 전`;
    //     } else if (calculated < 60 * 60 * 24) {
    //         return `${Math.round(calculated / (60 * 60))}시간 전`;
    //     } else if (calculated < 60 * 60 * 24 * 7) {
    //         return `${Math.round(calculated / (60 * 60 * 24))}일 전`;
    //     } else if (calculated < 60 * 60 * 24 * 7 * 5) {
    //         return `${Math.round(calculated / (60 * 60 * 24 * 7))}주 전`;
    //     } else if (calculated < 31536000) {
    //         return `${Math.round(calculated / 31536000)}달 전`;
    //     } else if (calculated > 31536000) {
    //         return `${Math.round(calculated / 31536000)}년 전`;
    //     }
    // }
    // return { remove, 
    //         addCommentReply, getTimeFromJavaDateForComment};

    //     }
    // }
</script>
<style scoped>

</style>
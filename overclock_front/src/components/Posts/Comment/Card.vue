<template>
  <div class="comment">
      <div class="commentId mt-3">
        <span class="commentMember">123456</span>
      </div>
      <div class="commentContent mt-3">
        <span class="commentText mt-1">힘세고 강한 아침</span>
      </div>
    </div>
  <div class="comment">
      <div class="commentId mt-3">
        <span class="commentMember">123456</span>
      </div>
      <div class="commentContent mt-3">
        <span class="commentText mt-1">힘세고 강한 아침</span>
      </div>
    </div>
</template>

<script>
export default {
    name:'ToCard',
    setup(){
      
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
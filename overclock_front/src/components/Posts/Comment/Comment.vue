<template>
  <div class="comment form-floating">
    <h4 class="hh4">댓글</h4>
    <textarea name="comment" id="comment" cols="100" rows="2"></textarea>
    <button class="btn btn-primary bbtn" type="submit">등록</button>
  </div>
</template>

<script>
export default {
  
};
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
}
.hh4{
  margin-left: 40px;
  margin-top: 5px;

}
.bbtn{
  margin-bottom: 45px;
  margin-left: 20px;
}


</style>

<template>
  <section id="hero" class="d-flex align-items-center justify-content-center">
    <div class="input-form form-floating">

    <div class="board-headers">
      <h3>{{ title }}</h3>
      <div>
        <strong class="w3-large">{{ memberId }}</strong>
        <br>
        <span>{{ regDate }}</span>
      </div>
    </div>
    <div class="board-contents">
      <span>{{ content }}</span>
    </div>
      <router-link to="/free" class="btn btn-primary">목록</router-link>
      </div>
  </section>
</template>

<script>
export default {
  name: "FreeDetail",
  setup() {},
};
</script>
<style scoped>
.input-form {
  text-align: center;

  width: 800px;

  max-width: 900px;
  height: 850px;

  margin-top: 80px;
  padding: 32px;

  background: #fff;
  -webkit-border-radius: 10px;
  -moz-border-radius: 10px;
  border-radius: 10px;
}
#hero h2 {
  color: rgb(0, 0, 0);
}
#hero h3 {
  color: rgb(0, 0, 0);
}
.col-lg-8 {
  max-height: 40vh;
}
p {
  margin-bottom: 1rem;
}
.board-headers{
  width: 100px;
  height: 100px;
  background: red;
}
.board-contents{
  width: 100px;
  height: 100px;
  background: blue;
}
</style>

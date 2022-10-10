<template>
      <section id="hero" class="d-flex justify-content-center">
    <div class="d-flex justify-content-center align-items-center">
        <div class="input-form form-floating">
            <h1 style="color: black;">
                로그아웃 완료!
            </h1>
        </div>
    </div>
    </section>
</template>

<script>
import { useRouter } from 'vue-router';
    export default {
    setup() {

const router = useRouter()
function home(){
    alert("로그아웃되었습니다.");
  router.push(`/`);
}
// setTimeout(home, 1000);
return{home}
    }
}
</script>

<style scoped>
  .input-form {
    text-align: center;
    padding: 32px;
  
    margin-top: 45px;
  
    background: #fff;
    -webkit-border-radius: 10px;
    -moz-border-radius: 10px;
    border-radius: 10px;
  }
</style>
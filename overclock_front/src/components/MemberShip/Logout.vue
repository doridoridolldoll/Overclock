<template>
    <div class="d-flex justify-content-center align-items-center h-100">
        <h1>로그아웃에 성공하였습니다</h1>
    </div>
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
setTimeout(home, 1000);
    }
}
</script>
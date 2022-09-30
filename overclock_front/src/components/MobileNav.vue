<template>
        <nav id="navbar" class="navbar order-last order-lg-0 navbar-mobile">
        <ul>
          <li><router-link to="/parts" class="nav-link scrollto" >부품</router-link></li>
          <li><router-link to="/peri" class="nav-link scrollto" >주변기기</router-link></li>
          <li><router-link to="/used" class="nav-link scrollto" >중고장터</router-link></li>
          <li><router-link to="/free" class="nav-link scrollto" >자유게시판 </router-link></li>
          <li><router-link to="/qna" class="nav-link scrollto" >고객센터 </router-link></li>
          <li><a class="nav-link scrollto" href="#contact">찾아오시는 길</a></li>
          <li class="dropdown-active"><a href="#">
            <i class="bi bi-person-square" style="font-size:x-large"></i>
            <i class="bi bi-chevron-down"></i></a>
            <ul>
              <li><router-link to="/profil" >내정보</router-link></li>
              <li><a href="#">주문내역</a></li>
              <li><router-link to="/login">로그인</router-link></li>
              <li><router-link to="/join">회원가입</router-link></li>
            </ul>
          </li> 
        </ul>
        </nav>

</template>

<script>
export default {

}
</script>

<style scoped>
.navbar-mobile ul{
    position: static;
    float: left;

    -webkit-border-radius: 10px;
      -moz-border-radius: 10px;
      border-radius: 10px;

}
.dropdown{
    background: red;
}
</style>
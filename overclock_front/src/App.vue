<template>
  <header id="header" class="fixed-top ">
    <div class="container d-flex align-items-center justify-content-lg-between">  
      

      <h1 class="logo me-auto me-lg-0"><router-link to="/">OverClock<span>.</span></router-link></h1>

      <nav id="navbar" class="navbar order-last order-lg-0">
        <ul>
          <li><router-link to="/parts" class="nav-link scrollto" >부품</router-link></li>
          <li><router-link to="/peri" class="nav-link scrollto" >주변기기</router-link></li>
          <li><router-link to="/used" class="nav-link scrollto" >중고장터</router-link></li>
          <li><router-link to="/free" class="nav-link scrollto" >자유게시판 </router-link></li>
          <li><router-link to="/qna" class="nav-link scrollto" >고객센터 </router-link></li>
          <li><a class="nav-link scrollto" href="#contact">찾아오시는 길</a></li>
          <li class="dropdown"><a href="#">
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
        <nav id="navbar" class="navbar order-last order-lg-0 navbar-mobile" >
        <ul>
          <li><router-link to="/parts" class="nav-link scrollto" >부품</router-link></li>
          <li><router-link to="/peri" class="nav-link scrollto" >주변기기</router-link></li>
          <li><router-link to="/used" class="nav-link scrollto" >중고장터</router-link></li>
          <li><router-link to="/free" class="nav-link scrollto" >자유게시판 </router-link></li>
          <li><router-link to="/qna" class="nav-link scrollto" >고객센터 </router-link></li>
          <li><a class="nav-link scrollto" href="#contact">찾아오시는 길</a></li>
          <li class="dropdown"><a href="#">
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
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->
    </div>

  </header>
  <router-view/>
</template>

<script>
export default {
    name: "App",
    setup() {
    },
}
</script>

<style>
@import url("https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css");
#header{
  background: black;
}
</style>

<template>
<div class="login">
  <body class="text-center">
    <main class="form-signin">
      <div class="input-form-backgroud row">
        <div class="aa">
        <div class="input-form col-md-12 mx-auto">
          <form>
            <i class="bi bi-person-workspace"></i>
            <h1 class="h3 mb-3 fw-normal">로그인</h1>

            <div class="form-floating">
              <input
                type="email"
                class="form-control"
                id="floatingInput"
                placeholder="name@example.com"
              />
              <label for="floatingInput">이메일</label>
            </div>
            <div class="form-floating">
              <input
                type="password"
                class="form-control"
                id="floatingPassword"
                placeholder="Password"
              />
              <label for="floatingPassword">비밀번호</label>
            </div>

            <div class="checkbox mb-3">
              <label>
                <input type="checkbox" value="remember-me" /> 아이디 저장
              </label>
            </div>
            <button class="w-100 btn btn-lg btn-primary" type="submit">
              Sign in
            </button>
            <button
              class="w-100 btn btn-ji btn-secondary"
              type="submit"
              style="margin-top: 10px"
            >
              Join in
            </button>
          </form>
        </div>
        </div>
      </div>
    </main>

  </body>
</div>

</template>

<script>
import { ref } from '@vue/reactivity'
export default {
    name:'ToLogin',
  setup(){
    const title = ref('Login')

    return {title}
  }


}
</script>

<style>
      .aa {
        width: 100%;
        height: 100%;
        background: linear-gradient(to bottom right, #fff 0vh, #fff 100vh);
      }
      body {
        background: linear-gradient(to top right,  #fff 0vh, #fff 100vh);
      }

      .input-form {
        max-width: 680px;

        margin-top: 80px;
        padding: 32px;

        background: #fff;
        -webkit-border-radius: 10px;
        -moz-border-radius: 10px;
        border-radius: 10px;
        -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
        -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
        box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      }

      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }



</style>
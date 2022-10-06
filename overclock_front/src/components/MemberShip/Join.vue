<template>
  <section id="hero" class="d-flex align-items-center justify-content-center">
  <div class="container2" data-aos="fade-up">

      <div class="container">
          <div class="input-form2 col-md-12 mx-auto">
            <span v-on:click="change('member')">
                <h3 class="asd">Member</h3>
            </span>
            <span v-on:click="change('company')">
                <h3 class="asd">Company</h3>
            </span>

            <div v-if="(state.form == 'member')">
                <MbJoin/>
            </div>
            <div v-if="(state.form == 'company')">
                <CpJoin/>
            </div>
          </div>
        </div>
      </div> 
  </section>

</template>

<script>
import MbJoin from './MbJoin.vue';
import CpJoin from './CpJoin.vue';
import {reactive} from '@vue/reactivity'
// import axios from 'axios'
// import router from '@/router'
export default {
  components: { MbJoin ,CpJoin },
  name:'ToJoin',
setup(){
   const state = reactive({
      form: "member",
    });
    function change(which){
        state.form = which;
    }
  return {state,change}
}
}
</script>

<style scoped>
.container2{
height: 100vh;
}
.input-form2 {
      text-align: center;
      padding: 32px;

      margin-top: 45px;

      background: #fff;
      -webkit-border-radius: 10px;
      -moz-border-radius: 10px;
      border-radius: 10px;
    }

#hero{
  overflow: scroll;

  max-height: 1100px;
}

#hero::before{
  height: 1100px;
}

</style>
<template>
  <ul class="actions mx-0 px-1">
      <li v-if="stat.result">
          <button type="button" v-on:click="router.push(`/modify?article=` + id)" class="border-0 bg-white"><span class="text-primary">Modify</span></button>
      </li>
  </ul>
  <ShareModal></ShareModal>
</template>
<script setup>
  import axios from "axios";
  import { ref, defineProps, reactive } from "vue";
  import { useRouter } from "vue-router";
  import { useStore } from 'vuex'
  const store = useStore()
  const router = useRouter();
  let props = defineProps(["id"]);
  let fav = ref(null);
  let report = ref(null);
  let save = ref(null);
  let stat = reactive({
      result : null
  })
  function modifiable() {
      const headers = {
          "Content-Type": "application/json; charset=utf-8",
          "Authorization": store.state.token,
          "userid" : store.state.userid
      }
      let body = {
          aid: new URLSearchParams(window.location.search).get("article"),
          userid: store.state.userid,
      }
      axios
      .post(store.state.axiosLink+"/api/article/modify/check", body, { headers })
      .then(function (res) {
          if (res.data.aid==props.id) {
              stat.result = true
          }else{
              stat.result = false
          }
      })
  }

  function getArticleFunctionStatus() {
      const url = store.state.axiosLink+"/api/article/functions";
      const headers = {
          "Content-Type": "application/json; charset=utf-8",
          "Authorization": store.state.token,
          "userid" : store.state.userid
      };
      let body = {
          userid: store.state.userid,
          aid: props.id,
      };

      axios
          .post(url, body, { headers })
          .then(function (res) {
              if (res.data.favo == true) {
                  fav.value.style.color = "#3041a9";
              }
              if (res.data.save == true) {
                  save.value.style.color = "#3041a9";
              }
              if (res.data.report == true) {
                  report.value.style.color = "red";
                  report.value.textContent = "Reported";
              }
          })
          .catch((e) => {
              console.log(e);
          });
  }
  getArticleFunctionStatus();
  modifiable()
</script>

<template>


    <!-- <input type="number" placeholder="금액 입력" v-model="state.price" style="width: 150px; border: 1px solid black; margin: 15px; text-align: center;" > -->
    <!-- <div @click="PaymentBtn">결제</div> -->

    <!-- <input type="number" placeholder="금액 입력" v-model="state.price" >
    <div @click="PaymentBtn">결제</div> -->
     <button class="btn btn-primary mt-3 me-2 mb-3" style="float: right;" @click="PaymentBtn">구매</button>


</template>

<script>
import { reactive } from 'vue';
import axios from 'axios';
const { IMP } = window;
export default {
  name: "ToTest",
  props: ["price","cartId"],
  setup(props){
    const state = reactive({
      cartId : props.cartId,
    });
    document.cookie = "safeCookie1=foo; SameSite=Lax";
    document.cookie = "safeCookie2=foo";
    document.cookie = "crossCookie=bar; SameSite=None; Secure";
    function PaymentBtn(BuyerEmail,jQuery){
      IMP.init("imp04806421");
      IMP.request_pay({ // param
        pg: "html5_inicis",
        pay_method: "card",
        merchant_uid: "ORD_" + new Date().getTime(),
        name: "overclock", // 상품명
        amount:  props.price, // 가격
        buyer_email: "",
        buyer_name: "테스터",
      }, rsp => { // callback
        console.log(rsp);
        if (rsp.success) {
          console.log(state.cartId);
          const url2 = "/api/cart/delete"
          const headers = {
            "Content-Type": "application/json; charset=utf-8",
          };

          axios.post(url2, state.cartId, { headers }).then(function (res) {
            alert("qwe")
            console.log(res);
          })
          jQuery.ajax({
            url: "{}", // 예: https://www.myservice.com/payments/complete
            method: "POST",
            headers: { "Content-Type": "application/json" },
            data: {
                imp_uid: rsp.imp_uid,
                merchant_uid: rsp.merchant_uid
            }
          }).done(function (data) {
            // 가맹점 서버 결제 API 성공시 로직
            console.log(data);
          })
          console.log("결제 성공");
        } else {
          console.log("결제 실패");
        }
      });
    }
    return {state,PaymentBtn}
  }
}
</script>


<style scoped>
  input[type="number"]::-webkit-outer-spin-button,
  input[type="number"]::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
  }
  input{ width:300px; border:0; border-bottom:1px #a8a8a8 solid; margin:0 10px 0; padding:0; height:40px; line-height:40px; outline: none; }
  .test{ display:flex; justify-content: center; align-items: center; height:100vh; }
  div{ width: 200px; height:40px; background-color:#ffffff; border:1px #a8a8a8 solid; color:black; display:flex; align-items: center; justify-content: center; cursor:pointer; }
</style>
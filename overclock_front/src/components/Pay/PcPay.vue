<template>

    <input type="number" placeholder="금액 입력" v-model="state.price" style="width: 150px; border: 1px solid black; margin: 15px; text-align: center;" >
    <div @click="PaymentBtn">결제</div>

</template>

<script>
import { reactive } from 'vue';


const { IMP } = window;

export default {
  name: "ToTest",
  props: ["price"],
  setup(props){
    const state = reactive({
      price: props.price,
    });
    document.cookie = "safeCookie1=foo; SameSite=Lax";
    document.cookie = "safeCookie2=foo";
    document.cookie = "crossCookie=bar; SameSite=None; Secure";

    function PaymentBtn(BuyerEmail,jQuery){
      IMP.init("imp04806421");
      IMP.request_pay({ // param
        pg: "html5_inicis",
        pay_method: "card",
        merchant_uid: "ORD20180131-0000016",
        name: "overclock",
        amount: state.price,
        buyer_email: "jinwoo@naver.com",
        buyer_name: "테스터",
        buyer_tel: "010-8832-4280",
        buyer_addr: "서울특별시 영등포구 당산동",
        buyer_postcode: "07222"
      }, rsp => { // callback
        console.log(rsp);
        if (rsp.success) {
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
import { createRouter, createWebHistory } from "vue-router"

import Main from "@/components/Main.vue"

import Logout from "@/components/MemberShip/Logout.vue"
import Login from "@/components/MemberShip/Login.vue"
import Join from "@/components/MemberShip/Join.vue"

import MbLogin from "@/components/MemberShip/MbLogin.vue"
import MbJoin from "@/components/MemberShip/MbJoin.vue"

import CpLogin from "@/components/MemberShip/MbLogin.vue"
import CpJoin from "@/components/MemberShip/MbJoin.vue"

import Profil from "@/components/Profil.vue"

import EmailFind from "@/components/MemberShip/EmailFind"
import PassFind from "@/components/MemberShip/PassFind"
import PassCheck from "@/components/MemberShip/PassCheck"


//고객센터
import QnA from "@/components/QnA.vue"
import QnAPost from "@/components/QnAPost.vue"

// //결제
import PcPay from '@/components/Pay/PcPay.vue'
// import PayComplete from '@/components/Pay/PayComplete.vue'

//부품
import Parts from "@/components/Posts/Parts/Parts.vue"
import PartsDetail from "@/components/Posts/Parts/PartsDetail.vue"
import PartsRegister from "@/components/Posts/Parts/PartsRegister.vue"
import PartsModify from "@/components/Posts/Parts/PartsModify.vue"

//주변기기
import Peri from "@/components/Posts/Peripherals/Peripherals.vue"
import PeriDetail from "@/components/Posts/Peripherals/PeriDetail.vue"
import PeriRegister from "@/components/Posts/Peripherals/PeriRegister.vue"

//중고거래
import Used from "@/components/Posts/Used/Used.vue"
import UsedDetail from "@/components/Posts/Used/UsedDetail.vue"
import UsedRegister from "@/components/Posts/Used/UsedRegister.vue"

//자유게시판
import FreeDetail from "@/components/Posts/Free/FreeDetail.vue"
import Free from "@/components/Posts/Free/Free.vue"
import FreePost from "@/components/Posts/Free/FreePost.vue"
import FreeRePost from "@/components/Posts/Free/FreeRePost.vue"

//댓글
import CommentModify from "@/components/Posts/Comment/CommentModify.vue"

//검색
import SearchList from "@/components/SearchList.vue"


import Cart from "@/components/Cart.vue"
import Auction from "@/components/Auction.vue"




const routes = [
    {path:"/",name:"Main", component: Main}, 
    {path:"/parts",name:"Parts", component: Parts}, 
    {path:"/peri",name:"Peri", component: Peri}, 
    {path:"/used",name:"Used", component: Used}, 
    {path:"/partsdetail",name:"PartsDetail", component: PartsDetail, props: { newsletterPopup: false }}, 
    {path:"/peridetail",name:"PeriDetail", component: PeriDetail, props: { newsletterPopup: false }}, 
    {path:"/useddetail",name:"UsedDetail", component: UsedDetail}, 
    {path:"/freedetail",name:"FreeDetail", component: FreeDetail}, 
    {path:"/free",name:"Free", component: Free}, 
    {path:"/freepost",name:"FreePost", component: FreePost}, 
    {path:"/freerepost",name:"FreeRePost", component: FreeRePost}, 
    {path:"/mblogin",name:"MbLogin", component: MbLogin}, 
    {path:"/mbjoin",name:"MbJoin", component: MbJoin},
    {path:"/cplogin",name:"CpLogin", component: CpLogin}, 
    {path:"/cpjoin",name:"CpJoin", component: CpJoin},
    {path:"/login",name:"Login", component: Login}, 
    {path:"/logout",name:"Logout", component: Logout}, 
    {path:"/join",name:"Join", component: Join},
    {path:"/qna",name:"QnA", component: QnA},
    {path:"/qnapost",name:"QnAPost", component: QnAPost},
    {path:"/profil",name:"Profil", component: Profil},
    {path:"/usedregister", name:"UsedRegister", component: UsedRegister},
    {path:"/periregister", name:"PeriRegister", component: PeriRegister},
    {path:"/partsregister", name:"PartsRegister", component: PartsRegister},
    {path:"/search", name: 'SearchList', component: SearchList},


    {path:"/cart", name: 'Cart', component: Cart},
    {path:"/auction", name: 'Auction', component: Auction},


    {path:"/emailFind", name: 'EmailFind', component: EmailFind},
    {path:"/passFind", name: 'PassFind', component: PassFind},
    {path:"/passCheck", name: 'PassCheck', component: PassCheck},
    

    

    {path:"/partsModify", name: 'PartsModify', component: PartsModify},
    {path:"/commentModify", name: 'CommentModify', component: CommentModify},
    {path:'/PcPay', name: 'PcPay', component: PcPay},
    ]
  
  const router = createRouter({
    scrollBehavior() {
      // always scroll to top
      return { top: 0 }
    },
    history: createWebHistory(), routes
  })
  
  export default router

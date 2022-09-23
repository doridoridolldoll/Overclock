import { createRouter, createWebHistory } from "vue-router"

import Main from "@/components/Main.vue"
import Login from "@/components/Login.vue"
import Join from "@/components/Join.vue"

//부품
import Parts from "@/components/Posts/Parts/Parts.vue"
import PartsDetail from "@/components/Posts/Parts/PartsDetail.vue"
import PartsRegister from "@/components/Posts/Parts/PartsRegister.vue"

//주변기기
import Peri from "@/components/Posts/Peripherals/Peripherals.vue"

//중고거래
import Used from "@/components/Posts/Used/Used.vue"
import UsedDetail from "@/components/Posts/Used/UsedDetail.vue"
import UsedRegister from "@/components/Posts/Used/UsedRegister.vue"

//자유게시판
import FreeDetail from "@/components/Posts/Free/FreeDetail.vue"
import Free from "@/components/Posts/Free/Free.vue"
import FreePost from "@/components/Posts/Free/FreePost.vue"
import FreeRePost from "@/components/Posts/Free/FreeRePost.vue"


const routes = [
    {path:"/",name:"Main", component: Main}, 
    {path:"/parts",name:"Parts", component: Parts}, 
    {path:"/peri",name:"Peri", component: Peri}, 
    {path:"/used",name:"Used", component: Used}, 
    {path:"/partsdetail",name:"PartsDetail", component: PartsDetail}, 
    {path:"/useddetail",name:"UsedDetail", component: UsedDetail}, 
    {path:"/freedetail",name:"FreeDetail", component: FreeDetail}, 
    {path:"/free",name:"Free", component: Free}, 
    {path:"/freepost",name:"FreePost", component: FreePost}, 
    {path:"/freerepost",name:"FreeRePost", component: FreeRePost}, 
    {path:"/login",name:"Login", component: Login}, 
    {path:"/join",name:"Join", component: Join},
    {path:"/usedregister", name:"UsedRegister", component: UsedRegister},
    {path:"/partsregister", name:"PartsRegister", component: PartsRegister}
  ]
  
  const router = createRouter({
    history: createWebHistory(), routes
  })
  
  export default router

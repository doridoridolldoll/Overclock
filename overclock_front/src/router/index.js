import { createRouter, createWebHistory } from "vue-router"

import Parts from "@/components/Parts.vue"
import Peri from "@/components/Peripherals.vue"
import Used from "@/components/Posts/Used.vue"
import PartsDetail from "@/components/Posts/PartsDetail.vue"
import UsedDetail from "@/components/Posts/UsedDetail.vue"
import FreeDetail from "@/components/Posts/FreeDetail.vue"
import Free from "@/components/Posts/Free.vue"
import FreePost from "@/components/Posts/FreePost.vue"
import FreeRePost from "@/components/Posts/FreeRePost.vue"
import Main from "@/components/Main.vue"
import Login from "@/components/Login.vue"
import Join from "@/components/Join.vue"
import UsedRegister from "@/components/UsedRegister.vue"

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
    {path:"/usedregister", name:"UsedRegister", component: UsedRegister}
  ]
  
  const router = createRouter({
    history: createWebHistory(), routes
  })
  
  export default router

<template>
  <section id="hero" class="d-flex align-items-center justify-content-center">
    <form class="form-floating input-form9 " @submit.prevent>
  <h5 class="mt-4">부품 거래 등록</h5>

            <div class="form-group">
                <label>상품명</label>
                <input type="text" v-model="state.title" class="form-control">
            </div>

            <div class="form-group">
                <label>제품상세</label>
                <textarea class ="form-control" v-model="state.itemDetail" rows="5" name="content"></textarea>
            </div>

            <div class="form-group">
                <label>가격</label>
                <input type="text" class ="form-control" v-model="state.price" rows="5" name="itemDetail">
            </div>

            <div class="form-group">
                <label>수량</label>
                <input type="text" class="form-control" v-model="state.stock" name="stock" placeholder="stock">
            </div>

            <!-- <div class="form-group" >
                <label>회원ID</label>
                <input type="text" class="form-control hidden" v-model="state.memberId" name="memberId" placeholder="memberId"><br>
            </div> -->

            <div class="box"></div>

            <FileUpload />

            <div class="form-group">
                <label>부품 카테고리</label><br>
                <select v-model="state.type" name="type">
                    <option>MB</option>
                    <option>CPU</option>
                    <option>GPU</option>
                    <option>HDD</option>
                    <option>ETC</option>
                </select>
            </div>
            <button class="btn btn-primary btn7 mt-3" @click="joinHandler">등록</button>

    </form>
    </section>
</template>

<script>
import {reactive} from '@vue/reactivity'
import axios from 'axios'
import {useRouter} from 'vue-router';
import FileUpload from '../../FileUpload.vue'
import store from '@/store';
export default {
    name:'ToRegister',
    components: { FileUpload },
    setup() {
        const router = useRouter();
        const state = reactive({
            title       : '',
            content: '',
            memberId  : store.state.id,
            name        : '',
            itemDetail : '',
            stock: '',  
            price: '',
            type : '',
            postsId : '',
            imageDTOList : new Array(),
        })
        const joinHandler = async() => {
            let str = "";
            const liArr = document.querySelectorAll(".uploadResult ul li")
            for(let i=0;i<liArr.length;i++){
                const target = liArr[i];
                str += `
                <input type="hidden" name="imageDTOList[${i}].imgName" 
                value="${target.dataset.name}">
                <input type="hidden" name="imageDTOList[${i}].path" 
                value="${target.dataset.path}">
                <input type="hidden" name="imageDTOList[${i}].uuid" 
                value="${target.dataset.uuid}">          
                `
                const obj = {
                imgName : target.dataset.name,
                path : target.dataset.path,
                uuid : target.dataset.uuid,
                }
                state.imageDTOList.push(obj)
            }
            document.querySelector(".box").innerHTML = str
            
            //글쓰기
            const url = '/register/posting'
            const headers = {
                "Content-Type" : "application/json",
                "Authorization": store.state.token,
                }
            const body = {
                title : state.title, 
                content: state.itemDetail,
                memberId : state.memberId, 
                imageDTOList: state.imageDTOList,
                partsType: state.type,
                token: store.state.token,
            }
            await axios.post(url, body, {headers}).then((res)=>{
                state.postsId = res.data;
                console.log(res.data);
            })


            const url2 = '/register/itemPosting'
            const body2 = {
                price: state.price,
                stock: state.stock,
                itemDetail: state.itemDetail,
                postsId : state.postsId 
            }
            await axios.post(url2,body2,{headers})
            router.push({name: "Parts"})
        }
        return {state,joinHandler }
    }
    
}
</script>

<style scoped>

  .input-form9 {

    text-align: center;

    max-width: 680px;
    max-height: 1200px;

    margin-top: 200px;
    padding: 32px;

    background: #fff;
    -webkit-border-radius: 10px;
    -moz-border-radius: 10px;
    border-radius: 10px;
  }
  .btn7{
    margin-top: 20px;
  }
#hero{
    overflow: scroll;
}
#hero:before{
    height: 1200px;
}
</style>
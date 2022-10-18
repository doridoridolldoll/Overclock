<template>
    <section id="hero" class="d-flex align-items-center justify-content-center">
        <form class="form-floating input-form9 " @submit.prevent>
            <h5 class="mt-4">부품 거래 수정</h5>
            <div class="form-group">
                <label>상품명</label>
                <input type="text" v-model="state.title" class="form-control">
            </div>
            <div class="form-group">
                <label>제품상세</label>
                <textarea class="form-control" v-model="state.content" rows="5" name="item_detail"></textarea>
            </div>
            <button class="btn btn-primary btn7" @click="modify">수정</button>
            <button class="btn btn-primary btn7" @click="deleted">삭제</button>
        </form>
    </section>
</template>

<script>
import axios from "axios";
import { useStore } from 'vuex'
import { reactive } from "vue";
import router from '@/router';

export default {
    name: "WritePage",

    setup() {
        const store = useStore();
        const state = reactive({
            id: store.state.dtoList.id,
            title: '',
            content: '',
        })


        const modify = async () => {
            store.state.dtoList.title = state.title;
            store.state.dtoList.content = state.content;
            const url = '/api/modify/send'
            const headers = {
                "Content-Type": "application/json"
            }
            const body = {
                id: state.id,
                title: state.title,
                content: state.content
            }

            await axios.post(url, body, { headers })
            alert("해당 게시글이 수정되었습니다.")
            await router.push(`/PartsDetail?id=${state.id}`)
            //    await router.push(`/PartsDetail?id=${state.postsId}`)  
        }
        const deleted = async () => {
            const url = '/api/delete'
            const headers = {
                "Content-Type": "application/json"
            }
            const body = {
                id: state.id,
                title: state.title,
                content: state.content
            }
            await axios.post(url, body, { headers })
            alert("해당 게시글이 삭제 되었습니다.")
            router.push("/parts")
        }
        return { state, modify, deleted }
    },
};
</script>

<style scoped>
.input-form9 {
    text-align: center;
    padding: 32px;

    background: #fff;
    -webkit-border-radius: 10px;
    -moz-border-radius: 10px;
    border-radius: 10px;
}

.btn7 {
    margin: 5px;
}
</style>
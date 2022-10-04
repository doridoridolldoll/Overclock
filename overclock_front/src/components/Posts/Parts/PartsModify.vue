<template>
        <section id="hero" class="d-flex align-items-center justify-content-center">|||
    <form class="form-floating input-form9 " @submit.prevent>
  <h5 class="mt-4">부품 거래 수정</h5>
            <div class="form-group">
                <label>상품명</label>
                <input type="text" v-model="state.title" class="form-control">
            </div>
            <div class="form-group">
                <label>제품상세</label>
                <textarea class ="form-control" v-model="state.content" rows="5" name="item_detail"></textarea>
            </div>
            
            <button class="btn btn-primary btn7" @click="modify">등록</button>
            <button class="btn btn-primary btn7" @click="deleted">삭제</button>

    </form>
    </section>
</template>

<script>
    import axios from "axios";
    import { useStore } from 'vuex'
    import { reactive } from "vue";

    export default {
        name: "WritePage",
        setup() {
            const store = useStore();
            const state = reactive({
                id: store.state.dtoList.id,
                title: '',
                content: '',
            })
            const modify = async() => {
                const url = '/api/modify/send'
                const headers = {
                "Content-Type" : "application/json"
                }
                const body= {
                    id: state.id,
                    title: state.title,
                    content: state.content
                }
            
                await axios.post(url, body, {headers} )
            }
            const deleted = async() => {
                const url = '/api/delete'
                const headers = {
                "Content-Type" : "application/json"
                }
                const body= {
                    id: state.id,
                    title: state.title,
                    content: state.content

                }
                console.log(state.id)
                console.log(typeof(state.id))
                await axios.post(url, body, {headers} )
            }
            return { state, modify, deleted }
        },
    };
</script>

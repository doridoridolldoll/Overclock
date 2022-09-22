<template>
<div>
<section id="hero" class="d-flex align-items-center justify-content-center">
    <div class="container" data-aos="fade-up">

      <div class="row justify-content-center" data-aos="fade-up" data-aos-delay="150">
        <div class="col-xl-6 col-lg-8">
          <h1>Powerful Digital Hardware With OverClock<span>.</span></h1>
          <h2>우리는 최고의 상품을 최적의 가격에 판매합니다</h2>
        </div>
      </div>

    </div>
  </section><!-- End Hero -->
<button><router-link to="/register"> 글쓰기</router-link></button>
  <main id="main">
    <section class="ftco-section ftco-cart">
			<div class="container">
				<div class="row">
    			<div class="col-md-12 ftco-animate">
    				<div class="cart-list">
	    				<table class="table">
						    <thead class="thead-primary">
						      <tr class="text-center">
                   				<th>글 번호</th>
						        <th>사진</th>
						        <th>제목</th>
						        <th>작성일</th>
						        <th>조회수</th>
						      </tr>
						    </thead>
						    <tbody>
						      <tr class="text-center" v-for="(list,i) in state.lists" :key="(list,i)">
						        <td class ="price"> {{list.id}} </td>
						        <td>
									<img v-bind:src= "state.img[i]">
								</td>
						        <td class="product-name">
						        	<h3>{{list.title}}</h3>
						        </td>
				            	<td class="price">{{list.regDate}}</td>
						        <td class="price"> {{list.viewCount}} </td>
			
						      </tr><!-- END TR-->
						    </tbody>
						  </table>
					  </div>
    			</div>
    		</div>
			</div>
		</section>
</main>
</div>
</template>

<script>
import { onMounted } from 'vue'
import { reactive } from '@vue/reactivity'
import axios from 'axios'

export default {
    name:'ToUsed',
	setup(){
		onMounted(() => {
      		handleGetList()
    	})
		const state = reactive({
      		lists: 	'',
			upResult    : '',
			img : [],
   		})
		const handleGetList = async () => {
			const url = '/api/getlist'
			const headers = {
				'Content-Type': 'application/json'
			}
			const body = { email: state.email }
			await axios.post(url, body, { headers }).then(function (res) {
				if (res.status === 200) {
					state.lists = res.data.dtoList;
					showResult(res.data)
				}
			})


		}
		const showResult = async(arr) => {
			const displayUrl = '/display'
			const url = `http://localhost:9090${displayUrl}`
			let str2 = "";
            for(let i=0;i<arr.dtoList.length;i++){
                str2 = `${url}?fileName=${arr.dtoList[i].imageDTOList[0].thumbnailURL}`
				state.img[i] = str2;
            }


		}
		return {state,handleGetList}
		}
	}

</script>	

<style>

</style>
<template>
	<!-- <div class="col maincards">
		<div class="card-1 card border-0 w-100 mb-5">
			<div v-for="(list,i) in props.imgUrl" :key="(list,i)">
				<div class="wrapper" :style="'background-image: url('+props.imgUrl[i]+'); background-size: cover;'">
				<div class="icon"></div>	
					<div class="data">
						<div class="content">
							<div @click="read()">
								<span class="author">{{ card.id }}</span>
								<h3 class="title"><a>{{ title }}</a></h3>
								<p class="text" v-html="props.card.content"></p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div> -->
	<section id="services" class="services">
      <div class="container" data-aos="fade-up">
	<div class="row">
		<div class="col-lg-4 col-md-6 align-items-stretch" data-aos="zoom-in" data-aos-delay="100"
		v-for="(list,i) in props.imgUrl" :key="(list,i)">
			<div class="icon-box">
				<!-- <div>{{card}}</div> -->
				<div class="icon"><img v-bind:src="props.imgUrl[i]" /></div>
				<br><br><br><br><br>
				<h3><a href="" style="width:292px;" >{{card[i].id}}</a></h3>
				<h3><a href="" style="width:292px;" >{{card[i].title}}</a></h3>
				
				<span><h5>할인가 4,300,000원</h5></span>	
			</div>
		</div>
	</div>
	</div>

	</section>
</template>

<script setup>
import { defineProps } from "vue";
// import router from "@/router";
// import store from "@/store";

const props = defineProps({
  card: Object,
  imgUrl: Object,
})
console.log("==================");
console.log(props.imgUrl);
// console.log(card.id);

// console.log(card);
// let title = titleLength(props.card.title);
// console.log(props.card)
// console.log("=============");
// console.log(props.imgUrl);

// function titleLength(title){
//   if (title.length < 30){
//     return title;
//   } else {
//     return title.substr(0, 30) + "...";
//   }
// }

// let image = imageslice(props.card.fileName);

// function imageslice(a){
//   if(a != null){
//     return a.slice(0, -1)
//   } else { return "basic.png"}
// }

// function read() {
//   router.push(`/read?article=${props.card.id}`)
// }

// const showResult = async (arr) => {
//           const displayUrl = "/display";
//           const url = `http://localhost:9090${displayUrl}`;
//           let str2 = "";
//           for (let i = 0; i < arr.dtoList.length; i++) {
//               str2 = `${url}?fileName=${arr.dtoList[i].imageDTOList[0].thumbnailURL}`;
// 			  console.log(str2)
//               state.img[i] = str2;
//           }
//       };

</script>

<style scoped>

</style>
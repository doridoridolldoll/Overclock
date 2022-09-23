<template>
    <div class="col-lg-4 col-md-6 d-flex align-items-stretch" data-aos="zoom-in" data-aos-delay="100"
    v-for="(list,i) in state.dtoList" :key="(list,i)"
    >
    <div class="icon-box">
        <div class="icon"><img v-bind:src="state.img[i]" /></div>
        <br><br><br><br><br>
        <h3><a href="" style="width:292px;" >{{list.title}}</a></h3>
        <span><h4>{{list.id}}</h4></span>
        <span><h5>판매가 4,800,000원</h5></span>
        <span><h5>할인가 4,300,000원</h5></span>
    </div>
    </div>
</template>

<script>
export default {

}
</script>

<style>

</style>
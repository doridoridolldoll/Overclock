<template>
  <div class="searchlist">
  <div class="all">
    <!-- 검색필터 -->
    <div class="btn-group" role="group" aria-label="Default button group">
      <button type="button" class="btn btn-outline-dark">조회순</button>
      <button type="button" class="btn btn-outline-dark">좋아요순</button>
      <button type="button" class="btn btn-outline-dark">평점순</button>
      <button type="button" class="btn btn-outline-dark">최신순</button>
    </div>
  </div>
  </div>
</template>
<script>
  export default {
    name: "SearchList"
  }
</script>
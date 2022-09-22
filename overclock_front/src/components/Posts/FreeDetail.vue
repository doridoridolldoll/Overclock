<template>
    <section id="hero" class="d-flex align-items-center justify-content-center">
        <div class="input-form form-floating">
            
            <div class="AddWrap">
                <form>
                    <h3>자유게시판</h3>
                    <table class="tbAdd">
					<colgroup>
						<col width="15%" />
						<col width="*" />
					</colgroup>
					<tr>
						<th>제목</th>
						<td>{{subject}}</td>
					</tr>
					<tr>
						<th>내용</th>
						<td class="txt_cont" v-html="cont"></td>
					</tr>
				</table>
			</form>
		</div>

            <router-link to="/free" class="btn btn-primary">목록</router-link>
	
	</div>
    </section>
  </template>
  
  <script>
  export default {
    name: "ToDetail",
    setup() {},
  };
  </script>
  <style scoped>
  .input-form {
    text-align: center;

    width: 800px;
  
    max-width: 900px;
    height: 850px;
  
    margin-top: 80px;
    padding: 32px;
  
    background: #fff;
    -webkit-border-radius: 10px;
    -moz-border-radius: 10px;
    border-radius: 10px;
  }
  #hero h2 {
    color: rgb(0, 0, 0);
  }
  #hero h3{
    color: rgb(0, 0, 0);
  }
  .col-lg-8{
    max-height: 40vh;
  }
  p{
    margin-bottom: 1rem;
  }
  .tbAdd{border-top:1px solid rgb(136, 136, 136);}
	.tbAdd th, .tbAdd td{border-bottom:1px solid #eee; padding:5px 0; }
	.tbAdd td{padding:10px 300px; box-sizing:border-box; text-align:left;}
	.tbAdd td.txt_cont{height:300px; vertical-align:top;}
	.btnWrap{text-align:center; margin:20px 0 0 0;}
	.btnWrap a{margin:0 10px;}
	.btnAdd {background:#43b984}
	.btnDelete{background:#f00;}
  </style>
  
<template>
  <section id="hero" class="d-flex align-items-center justify-content-center">
    <div class="input-form11 col-md-12 mx-auto form-floating">
      <div class="top-margin">
        <div class="mb-4">
          <span class="home-title">글 등록</span>
        </div>
      </div>
      <div>
        <input type="text" placeholder="제목" class="form-control my-3 rounded-0 title form-floating" v-model="title"
          id="title" />
        <ckeditor @ready="onReady" :editor="editor" v-model="editorData" :config="editorConfig"></ckeditor>
        <div class="tagwarning" ref="warning"></div>
        <button class="btn btn-primary m-3" @click.prevent="submit">글 쓰기</button>
      </div>
    </div>
  </section>
</template>

<script>
import CKEditor from "@ckeditor/ckeditor5-vue";
import router from "@/router"
import ClassicEditor from "@ckeditor/ckeditor5-build-classic";
import axios from 'axios'
import store from "@/store";
export default {
  name: "CKEditor2",
  components: {
    ckeditor: CKEditor.component,
  },
  data(props) {
    console.log(props);
    return {
      title: "",
      editor: ClassicEditor,
      editorData: "",
      editorConfig: {
        height: "500px",
        language: "ko",
        simpleUpload:
        {
          uploadUrl: store.state.axiosLink + "/api/article/write/image",
          withCredentials: true,
          headers: {
            "Authorization": store.state.token,
            "userid": store.state.memberId
          }
        }
      },
    }
  },
  methods: {
    onReady: function onReady(editor) {
      editor.ui.getEditableElement().parentElement.insertBefore(editor.ui.view.toolbar.element, editor.ui.getEditableElement())
    },
    submit: async function () {
      const page = {
        atitle: this.title,
        context: this.editorData,
        userId: store.state.memberId,
        token: store.state.token,
        images: []
      }
        //find image name where in context
        function findImageName(list) {
          let bonary = list.split("/")
          let filenames = new Array

          for (let i in bonary) {
            if (bonary[i].split("-").length == 5) {
              let tmp = bonary[i].slice(0, bonary[i].indexOf('>\n<') - 1)
              if (tmp.split('"')[2] != "YouTube video player") {
                filenames.push({
                  fileName: tmp
                })
              }
            }
          }
          return filenames
        }
        page.images = findImageName(page.context)
        let result = JSON.stringify(page)
        const url = store.state.axiosLink + "/api/article/write"
        const headers = {
          "Content-Type": "application/json; charset=utf-8",
          "Authorization": store.state.token,
          "userid": store.state.memberId
        }
        const body = result
        await axios.post(url, body, { headers }).then(function (res) {
          console.log(res);//글번호들어옴
          sessionStorage.setItem("aid", res.data)
          // router.push({name : "readReview", params: {"articleId" : res.data}})
          router.push(`/read?article=${res.data}`)
        }).catch((e) => {
          console.log(e + "fail");
        }).then(
          console.log("end")
        )
      },
    },
  }
</script>
  
<style>
.btn4 {
  margin-top: 10px;
}

.ck-editor__editable {
  max-height: 50vh;
  height: 50vh;
}

.input-form11 {
  text-align: center;
  padding: 32px;

  max-width: 840px;

  background: #fff;
  -webkit-border-radius: 10px;
  -moz-border-radius: 10px;
  border-radius: 10px;
}
</style>

<template>
  <section id="hero" class="d-flex align-items-center justify-content-center">
    <div class="input-form12 col-md-12 mx-auto form-floating">
      <div class="top-margin">
        <div class="mb-4">
          <span class="home-title">글 수정</span>
        </div>
      </div>
      <div>
        <input
          type="text"
          placeholder="제목"
          class="form-control my-3 rounded-0 title form-floating"
          v-model="title"
          id="title"
        />
        <ckeditor
          @ready="onReady"
          :editor="editor"
          v-model="editorData"
          :config="editorConfig"
        ></ckeditor>
        <div class="tagwarning" ref="warning"></div>
        <button
          class="btn btn-primary btn4"
          type="button"
          data-bs-toggle="offcanvas"
          data-bs-target="#offcanvasBottom"
          aria-controls="offcanvasBottom"
        >
          수정하기
        </button>
      </div>
    </div>
  </section>
</template>

<script>
import ClassicEditor from "@ckeditor/ckeditor5-build-classic";
import CKEditor from "@ckeditor/ckeditor5-vue";

export default {
  name: "CKEditor",
  components: {
    ckeditor: CKEditor.component,
  },
  data: () => ({
    title: "",
    editor: ClassicEditor,
    editorConfig: {
      height: "500px",
      language: "ko",
    },
  }),
  methods: {
    onReady: function onReady(editor) {
      editor.ui
        .getEditableElement()
        .parentElement.insertBefore(
          editor.ui.view.toolbar.element,
          editor.ui.getEditableElement()
        );
    },
  },


};
</script>

<style>
  .btn4 {
    margin-top: 10px;
  }
  .ck-editor__editable {
    max-height: 50vh;
    height: 50vh;
  }
  .input-form12 {
        text-align: center;
        padding: 32px;
  
        max-width: 840px;
  
        background: #fff;
        -webkit-border-radius: 10px;
        -moz-border-radius: 10px;
        border-radius: 10px;
      }
  #hero:before{
  height: 5000px;
      }

  
  </style>
  
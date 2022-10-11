<template>
    <!-- teleport: 렌더링 시 위치를 지정합니다. -->
    <teleport to="body">
      <!-- Modal의 열리고 닫힘을 관리합니다. -->
      <div class="backdrop" v-if="state.isVisible">
        <div class="modal-container">
          <!-- slot을 통해 BaseComponent를 확장시킵니다. -->
          <slot></slot>
        </div>
      </div>
    </teleport>
  </template>
  
  <script>
//   import { ref } from "vue";
import {reactive} from '@vue/reactivity'
  export default {
    name: 'ToBeModal',
    setup() {
        const state = reactive({
            isVisible : 0
        })
  
        // 부모 컴포넌트에서 접근하기 위한 함수를 선언합니다.
        const open = async() => {
            state.isVisible = 1;
        };
    
        const close = async() => {
            state.isVisible = 0;
        };
        
        // setup 함수에서 리턴해주어야, 부모 컴포넌트에서 접근이 가능합니다.
        return {
            open,
            close,
            state
        };
    },
  };
  </script>
  
  <style lang="scss" scoped>
  .backdrop {
    z-index: 999;
    display: flex;
    position: fixed;
    align-items: center;
    justify-content: center;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: rgba($color: #000000, $alpha: 0.2);
  
    .modal-container {
      background: white;
      max-width: 320px;
      width: 100%;
      padding: 1.5rem;
      border-radius: 10px;
    }
  }
  </style>
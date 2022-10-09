<template>
  <section id="hero" class="d-flex justify-content-center">
    <div class="container portfolio-details input-form">
      <div id="timer">
        <div class="aucImgTop">
        <div class="aucImg">
          이미지 들어갈 자리임
        </div>
      </div>
        <div class="timer">
          <div class="time">
            {{ formatTime }}
          </div>
          <button v-on:click="start" v-if="!timerOn">Start</button>
          <button v-on:click="stop" v-if="timerOn">Stop</button>
        </div>
      </div>
      <div class="aucPri">
        <h5 class="mt-1">입찰가: </h5>
        <input type="number" style="margin-left: 10px; margin-right: 30px;">
        <button type="submit" class="btn btn-primary">입찰</button>
      </div>
      <hr>
      <div class="aucNow">
        <h2 class="Now">현재 입찰가</h2>
        <h3>999,999원</h3>
      </div>
      <!-- <Comment/> -->
    </div>
  </section>
</template>

<script>
// import Comment from './Posts/Comment/Comment.vue';
export default {
    name: "ToTimer",
    data() {
        return {
            hou: 23,
            min: 59,
            sec: 59,
            timerOn: false,
            timerObj: null,
        };
    },
    methods: {
        count: function () {
            if (this.min <= 0 && this.hou >= 1) {
                this.hou--;
                this.min = 59;
            }
            else if (this.sec <= 0 && this.min >= 1) {
                this.min--;
                this.sec = 59;
            }
            else if (this.sec <= 0 && this.min <= 0) {
                this.complete();
            }
            else {
                this.sec--;
            }
        },
        start: function () {
            let self = this;
            this.timerObj = setInterval(function () { self.count(); }, 1000);
            this.timerOn = true;
        },
        stop: function () {
            clearInterval(this.timerObj);
            this.timerOn = false;
        },
        complete: function () {
            clearInterval(this.timerObj);
        },
    },
    computed: {
        formatTime: function () {
            let timeStrings = [
                this.hou.toString(),
                this.min.toString(),
                this.sec.toString(),
            ].map(function (str) {
                if (str.length < 2) {
                    return "0" + str;
                }
                else {
                    return str;
                }
            });
            return timeStrings[0] + ":" + timeStrings[1] + ":" + timeStrings[2];
        },
    },
    // components: { Comment }
};
</script>

<style scoped>
#hero h2{
  color: black;
  font-size: 40px;
}

#hero:before{
  height: 2000px;
}
#hero{
    overflow: scroll;
}

.input-form {
  margin-top: 50px;

  text-align: center;

  max-width: 900px;

  padding: 32px;

  background: #fff;
  -webkit-border-radius: 10px;
  -moz-border-radius: 10px;
  border-radius: 10px;

  overflow: hidden;

  word-break: break-all;
}
#timer {
  display: flex;
  align-items: center;
  justify-content: right;
}
.timer{
    border: 2px solid rgb(211, 211, 211);

}
.aucImgTop{
  border: 2px solid rgb(211, 211, 211); 
  margin-right: 50px
}
.aucImg{
  background-color:lightgray; 
  width:200px;
  height: 200px;
   margin: 100px;  }
.aucPri{
  display: flex;
  justify-content: right;
  align-items: center;
}
.Now{
  font-weight: 800px;
}
.time {
  font-size: 90px;
}
</style>

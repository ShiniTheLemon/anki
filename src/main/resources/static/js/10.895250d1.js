"use strict";(self["webpackChunkanki"]=self["webpackChunkanki"]||[]).push([[10],{9010:function(a,o,e){e.r(o),e.d(o,{default:function(){return W}});var t=e(3396),l=e(7139),r=e(5096);const n=a=>((0,t.dD)("data-v-4fd85265"),a=a(),(0,t.Cn)(),a),u={style:{color:"red"}},d={class:"card"},s={class:"inner-box",id:"card"},i={class:"card-front"},c=n((()=>(0,t._)("h2",null,"SLOTH-HELPER",-1))),m=n((()=>(0,t._)("img",{src:r},null,-1))),f={style:{color:"red"}};function p(a,o,e,r,n,p){const w=(0,t.up)("a-typography-title"),_=(0,t.up)("a-input"),k=(0,t.up)("a-form-item"),h=(0,t.up)("a-input-password"),v=(0,t.up)("a-button"),W=(0,t.up)("router-link"),g=(0,t.up)("a-space"),y=(0,t.up)("a-form");return(0,t.wg)(),(0,t.iD)("div",u,[(0,t._)("div",d,[(0,t._)("div",s,[(0,t._)("div",i,[c,(0,t.Wm)(w,{class:"title"},{default:(0,t.w5)((()=>[(0,t.Uk)(" Forgot Password ")])),_:1}),m,(0,t.Wm)(y,{model:r.form,class:"touch"},{default:(0,t.w5)((()=>[(0,t.Wm)(k,{field:"account",label:"Email"},{default:(0,t.w5)((()=>[(0,t.Wm)(_,{modelValue:r.form.account,"onUpdate:modelValue":o[0]||(o[0]=a=>r.form.account=a),placeholder:"please enter your email..."},null,8,["modelValue"])])),_:1}),(0,t.Wm)(k,{field:"password",label:"Verification Key"},{default:(0,t.w5)((()=>[(0,t.Wm)(h,{modelValue:r.form.password,"onUpdate:modelValue":o[1]||(o[1]=a=>r.form.password=a),placeholder:"Enter your verification token"},null,8,["modelValue"])])),_:1}),(0,t.Wm)(k,null,{default:(0,t.w5)((()=>[(0,t.Wm)(v,{type:"primary",status:"success",onClick:r.handleSubmit},{default:(0,t.w5)((()=>[(0,t.Uk)("Login")])),_:1},8,["onClick"])])),_:1}),(0,t.Wm)(k,null,{default:(0,t.w5)((()=>[(0,t._)("div",f,(0,l.zw)(r.logininfo),1)])),_:1}),(0,t.Wm)(g,null,{default:(0,t.w5)((()=>[(0,t.Wm)(W,{to:"/"},{default:(0,t.w5)((()=>[(0,t.Uk)("Go back to Login?")])),_:1})])),_:1})])),_:1},8,["model"])])])])])}e(7658);var w=e(4870),_=e(6624),k={name:"ForgotPasswordComponent",setup(){const a=(0,w.iH)(),o=(0,w.qj)({account:"",password:""}),e=(0,t.f3)("$axios"),l=(0,t.f3)("$router"),r=()=>{console.log(o.account),e({url:"/anki/vertify.do",method:"post",data:"email="+o.account+"&verification="+o.password,headers:{}}).then((a=>{200==a.data.status?l.push("/reset"):_.Z.error({title:"Error",content:a.data.info})}))};return{form:o,handleSubmit:r,logininfo:a}}},h=e(89);const v=(0,h.Z)(k,[["render",p],["__scopeId","data-v-4fd85265"]]);var W=v}}]);
//# sourceMappingURL=10.895250d1.js.map
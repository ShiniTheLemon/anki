"use strict";(self["webpackChunkanki"]=self["webpackChunkanki"]||[]).push([[923],{3923:function(a,e,o){o.r(e),o.d(e,{default:function(){return b}});var t=o(3396),l=o(7139),r=o(5096);const n=a=>((0,t.dD)("data-v-011989b8"),a=a(),(0,t.Cn)(),a),u={style:{color:"red"}},d={class:"card"},s={class:"inner-box",id:"card"},i={class:"card-front"},c=n((()=>(0,t._)("h2",null,"SLOTH-HELPER",-1))),m=n((()=>(0,t._)("img",{src:r},null,-1))),f={style:{color:"red"}};function p(a,e,o,r,n,p){const w=(0,t.up)("a-typography-title"),_=(0,t.up)("a-input"),k=(0,t.up)("a-form-item"),h=(0,t.up)("a-input-password"),v=(0,t.up)("a-button"),b=(0,t.up)("router-link"),W=(0,t.up)("a-space"),y=(0,t.up)("a-form");return(0,t.wg)(),(0,t.iD)("div",u,[(0,t._)("div",d,[(0,t._)("div",s,[(0,t._)("div",i,[c,(0,t.Wm)(w,{class:"title"},{default:(0,t.w5)((()=>[(0,t.Uk)(" Forgot Password ")])),_:1}),m,(0,t.Wm)(y,{model:r.form,class:"touch"},{default:(0,t.w5)((()=>[(0,t.Wm)(k,{field:"account",label:"Email"},{default:(0,t.w5)((()=>[(0,t.Wm)(_,{modelValue:r.form.account,"onUpdate:modelValue":e[0]||(e[0]=a=>r.form.account=a),placeholder:"please enter your email..."},null,8,["modelValue"])])),_:1}),(0,t.Wm)(k,{field:"password",label:"Verification Key"},{default:(0,t.w5)((()=>[(0,t.Wm)(h,{modelValue:r.form.password,"onUpdate:modelValue":e[1]||(e[1]=a=>r.form.password=a),placeholder:"Enter your verification token"},null,8,["modelValue"])])),_:1}),(0,t.Wm)(k,null,{default:(0,t.w5)((()=>[(0,t.Wm)(v,{type:"primary",status:"success",onClick:r.handleSubmit},{default:(0,t.w5)((()=>[(0,t.Uk)("Ok")])),_:1},8,["onClick"])])),_:1}),(0,t.Wm)(k,null,{default:(0,t.w5)((()=>[(0,t._)("div",f,(0,l.zw)(r.logininfo),1)])),_:1}),(0,t.Wm)(W,null,{default:(0,t.w5)((()=>[(0,t.Wm)(b,{to:"/"},{default:(0,t.w5)((()=>[(0,t.Uk)("Go back to Login?")])),_:1})])),_:1})])),_:1},8,["model"])])])])])}o(7658);var w=o(4870),_=o(6624),k={name:"ForgotPasswordComponent",setup(){const a=(0,w.iH)(),e=(0,w.qj)({account:"",password:""}),o=(0,t.f3)("$axios"),l=(0,t.f3)("$router"),r=()=>{console.log(e.account),o({url:"/anki/vertify.do",method:"post",data:"email="+e.account+"&verification="+e.password,headers:{}}).then((a=>{200==a.data.status?l.push("/reset"):_.Z.error({title:"Error",content:a.data.info})}))};return{form:e,handleSubmit:r,logininfo:a}}},h=o(89);const v=(0,h.Z)(k,[["render",p],["__scopeId","data-v-011989b8"]]);var b=v}}]);
//# sourceMappingURL=923.d5d869a4.js.map
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2022/5/14
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录</title>
    <meta charset="utf-8">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/static/imgs/favicon.ico" />
    <link href="${pageContext.request.contextPath}/static/css/login-style.css" rel='stylesheet'/>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
<!-----start-main---->
<div class="main">
    <div class="login-form">
        <h1></h1>
        <div class="head">
            <img src="${pageContext.request.contextPath}/static/imgs/user.gif" alt="RUA!"/>
        </div>
        <!-- 表单区域 -->
        <form action="#" id="user-info-form">
            <span class="tip"></span>
            <input type="text" class="text" placeholder="username" name="userName"/>
            <input type="password" placeholder="password" name="password"/>
            <input type="text" class="email-input" placeholder="email" name="email"/>
            <div class="submit">
                <input type="submit" value="登录"/>
            </div>
            <p><a href="javascript:;" id="state-toggle">注册</a></p>
        </form>
    </div>
    <!-- start-copyright -->
    <div class="copy-right">
        <p>Copyright &copy; Group 10th</p>
    </div>
    <!-- end-copyright -->
</div>
<!-- end-main -->
<script>
    $(function () {
        // init page
        loginUi()

        // functions
        function loginUi() {
            $(".email-input").css("display", "none")
            $(".submit>input[type=submit]").val("登录")
            $("#state-toggle").html("注册")
        }

        function registerUi() {
            $(".email-input").stop().slideDown()
            $(".submit>input[type=submit]").val("注册")
            $("#state-toggle").html("登录")
        }

        function login() {
            $.ajax({
                url: "${pageContext.request.contextPath}/userLogin",
                type: "POST",
                data: $("#user-info-form").serialize(),
                success(result) {
                    console.log(result)
                    if(result.status === 200) {
                        location.replace("${pageContext.request.contextPath}/index")
                    } else {
                        $("span.tip").html(result.data.loginFailMessage)
                    }
                }
            })
        }

        function register() {
            const submitBtn = $("div.submit>input[type=submit]")
            let validateEmailResult = submitBtn.attr("validateEmailResult")
            let validatePasswordResult = submitBtn.attr("validatePasswordResult")
            let validateUserNameResult = submitBtn.attr("validateUserNameResult")
            if(validateEmailResult==="true"
                &&validatePasswordResult==="true"
                &&validateUserNameResult==="true") {
                $.ajax({
                    url: "${pageContext.request.contextPath}/userNameCheck",
                    type: "GET",
                    data: $("form#user-info-form").serialize(),
                    success(result) {
                        // No duplicate name
                        if(result.status === 200) {
                            $.ajax({
                                url: "${pageContext.request.contextPath}/userRegister",
                                type: "POST",
                                data: $("#user-info-form").serialize(),
                                success(result) {
                                    if(result.status === 200) {
                                        alert("注册成功!")
                                        loginUi()
                                    } else {
                                        $("span.tip").html("注册失败!")
                                    }
                                }
                            })
                        } else {
                            // Name duplicate
                            $("span.tip").html("注册失败, 用户名重复!")
                        }
                    }
                })
            } else {
                $("span.tip").html("注册失败, 用户信息格式不正确!")
            }
        }

        // events
        $("div.submit>input[type=submit]").on("click", function (event) {
            event.preventDefault()
            let submitBtnState = $(this).val()
            if (submitBtnState === "登录") {
                login()
            } else if (submitBtnState === "注册") {
                register()
            }
        })

        $("a#state-toggle").on('click', function (event) {
            event.preventDefault()
            $("span.tip").html("")
            let uiState = $(this).html()
            if (uiState === "注册") {
                $("#user-info-form")[0].reset()
                registerUi()
            } else if (uiState === "登录") {
                $("#user-info-form")[0].reset()
                loginUi()
            }
        })

        $("input:text[name=email]").on("blur", function () {
            if($(".submit>input[type=submit]").val() !== "注册") return
            let emailInput = $(this).val()
            const emailRegExp = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
            if(!emailRegExp.test(emailInput)) {
                $("div.submit>input[type=submit]").attr("validateEmailResult", "false")
                $("span.tip").html("邮箱格式不合法")
            } else {
                $("span.tip").html("")
                $("div.submit>input[type=submit]").attr("validateEmailResult", "true")
            }
        })

        $("input:password[name=password]").on("blur", function () {
            if($(".submit>input[type=submit]").val() !== "注册") return
            let passwordInput = $(this).val()
            const passwordRegExp = /^.{4,20}$/
            if(!passwordRegExp.test(passwordInput)) {
                $("span.tip").html("密码不合法，应为4-20位的字符串")
                $("div.submit>input[type=submit]").attr("validatePasswordResult", "false")
            } else {
                $("span.tip").html("")
                $("div.submit>input[type=submit]").attr("validatePasswordResult", "true")
            }
        })

        $("input:text[name=userName]").on("blur", function () {
            if($(".submit>input[type=submit]").val() !== "注册") return
            let userNameInput = $(this).val()
            const userNameRegExp = /^[a-zA-Z][a-zA-Z0-9_]{4,15}$/
            if(!userNameRegExp.test(userNameInput)) {
                $("span.tip").html("用户名不合法")
                $("div.submit>input[type=submit]").attr("validateUserNameResult", "false")
            } else {
                $("span.tip").html("")
                $("div.submit>input[type=submit]").attr("validateUserNameResult", "true")
            }
        })
    })
</script>
</body>
</html>

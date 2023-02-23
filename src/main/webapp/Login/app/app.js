const Mail = document.querySelector('#inputUsername')
const Password = document.querySelector('#inputPassword')
const LoginBtn = document.querySelector('#LoginBtn')
const errorSoundEffect = new Audio('../sounds/Error%20sound%20effect.mp3')


LoginBtn.addEventListener('click',()=>{
    if(Mail.value == '' || Password.value == ''){
        errorSoundEffect.play()
    }  
})
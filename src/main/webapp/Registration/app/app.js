const Email = document.querySelector('.inputEmail')
const Password = document.querySelector('.inputPassword')
const PasswordConfirm = document.querySelector('.inputPasswordConfirm')
const Name = document.querySelector('.inputName')
const Surname = document.querySelector('.inputSurname')
const Proffersion = document.querySelector('.inputProffesion')
const PasswordConfirmDiv = document.querySelector('.passwordConfirmDiv')
const registerBtn = document.querySelector('.registerBtn')
const Inputs = document.querySelectorAll('.input')
const confirmedSoundEffect = new Audio('../sounds/verify%20sound%20effect.mp3')
const errorSoundEffect = new Audio('../sounds/Error%20sound%20effect.mp3')




Password.addEventListener('keyup',()=>{
    if(Password.value.length == 0){
        document.querySelector('.passwordError').textContent = ''
    }else if(Password.value.length < 8){
        document.querySelector('.passwordError').textContent = 'password should contain 8 characters or more'
        registerBtn.style.pointerEvents = 'none'

    }else{
        registerBtn.style.pointerEvents = 'auto'
        setTimeout(()=>{
            document.querySelector('.passwordError').textContent = ``
        },500) 
    }
    checkPassConfirm(Password,PasswordConfirm)
})


PasswordConfirm.addEventListener('keyup',()=>{
    console.log(PasswordConfirm.value.length);
    if(PasswordConfirm.value == ''){
        document.querySelector('.passwordConfirmError').textContent = ``
    }
    checkPassConfirm(Password,PasswordConfirm)
})

function checkPassConfirm(Password,PasswordConfirm){
    if((PasswordConfirm.value != Password.value )&&PasswordConfirm.value != ''){
        registerBtn.style.pointerEvents = 'none'
        document.querySelector('.passwordConfirmError').style.color = 'red'
        document.querySelector('.passwordConfirmError').textContent = `Passwords don't match`
    }else if(((PasswordConfirm.value == Password.value )&&PasswordConfirm.value != '') && PasswordConfirm.value.length < 8){
        document.querySelector('.passwordConfirmError').textContent = `you got it but password should contain 8 characters or more`

    }
    else if(((PasswordConfirm.value == Password.value )&&PasswordConfirm.value != '') && PasswordConfirm.value.length >= 8){
        registerBtn.style.pointerEvents = 'auto'
        document.querySelector('.passwordConfirmError').textContent = `You got it`
        document.querySelector('.passwordConfirmError').style.color = 'blue'
        confirmedSoundEffect.play()
        setTimeout(()=>{
            document.querySelector('.passwordConfirmError').textContent = ``
        },1000)
    }
}

registerBtn.addEventListener('click',()=>{
    if(Email.value.includes('@') && Email.value.includes('.com')){
            for(let i = 0;i < Inputs.length; i++){
                if(Inputs[i].hasAttribute('required') && Inputs[i].value == ''){
                    errorSoundEffect.play()
                }
        }
    }else{
        errorSoundEffect.play()
    }
})
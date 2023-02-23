const generateBtn = document.querySelector('.generateMemeBtn')
const generatedImg = document.querySelector('.generated_image img')
const generatedName = document.querySelector('.generated_meme_name')
const backgroundImg = document.querySelector('.background_img')
let meme = localStorage.getItem('currentMeme')
let previousMeme = localStorage.getItem('previousMeme')

const updateHtml = (src) => {
    generatedImg.setAttribute('src',src)
}

const updateBackground = (src = '') => {
    backgroundImg.setAttribute('src',src)
}
console.log(previousMeme);

updateHtml(meme)
if(previousMeme === null){
    updateBackground('https://th-thumbnailer.cdn-si-edu.com/aUe1YBoTF6kwxa47OTAQ8B2o_DE=/800x600/filters:no_upscale()/https://tf-cmsv2-photocontest-smithsonianmag-prod-approved.s3.amazonaws.com/5bbba419-a8c5-4f45-b5d2-d64345c2f369.jpg')
}else{
    updateBackground(previousMeme)
}

const GenerateMeme = () => {
    previousMeme = meme
    console.log(previousMeme,' : past meme');
    localStorage.setItem('previousMeme',previousMeme)
    // console.log(meme);
    fetch('https://api.memegen.link/images')
    .then((res)=> res.json())
    .then((data) => {
        meme = data[Math.floor(Math.random() * data.length)].url
        updateHtml(meme)
        console.log(meme, ' : current meme');
        localStorage.setItem('currentMeme',meme)
        if(previousMeme !== null){
            setTimeout(() => {
                updateBackground(previousMeme)
            }, 500);
        }else{
            updateBackground('https://th-thumbnailer.cdn-si-edu.com/aUe1YBoTF6kwxa47OTAQ8B2o_DE=/800x600/filters:no_upscale()/https://tf-cmsv2-photocontest-smithsonianmag-prod-approved.s3.amazonaws.com/5bbba419-a8c5-4f45-b5d2-d64345c2f369.jpg')
        }
        
    })
}
generateBtn.addEventListener('click',GenerateMeme)
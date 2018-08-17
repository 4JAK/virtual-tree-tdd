let socials = {
    facebook: {
      url: 'https://ed.team/facebook',
      icon: 'https://ed.team/sites/default/files/social-icons/facebook-icon.png'
    } ,
    youtube: {
      url: 'https://ed.team/youtube',
      icon: 'https://ed.team/sites/default/files/social-icons/youtube-icon.png'
    },
    twitter: { 
      url: 'https://ed.team/twitter',
      icon: 'https://ed.team/sites/default/files/social-icons/twitter-icon.png'
    },
    linkedin: {
      url: 'https://ed.team/linkedin',
      icon: 'https://ed.team/sites/default/files/social-icons/linkedin-icon.png'
    },
    github: {
      url: 'https://ed.team/github',
      icon: 'https://ed.team/sites/default/files/social-icons/github-icon.png'
    } 
  }
  
  let socialIcons = '';
  for(let social in socials) {
    socialIcons += `<a href="${socials[social].url}" style="display:inline-block;margin-right:6px"><img src="${socials[social].icon}" width="20" style="display: block"></a>`
  }
  
  document.getElementById('sociales').innerHTML = socialIcons;
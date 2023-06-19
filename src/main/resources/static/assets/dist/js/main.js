document.addEventListener('DOMContentLoaded', function () {
  const menuList = document.getElementsByClassName('comp-menu-list')
  const menuContent = document.getElementsByClassName('comp-menu-content')
  let tmp = null
  for (let i = 0; i < menuList.length; i++) {
    // 滑鼠移入時
    menuList[i].addEventListener('mouseenter', function () {
      if (tmp != null) {
        tmp.classList.add('d-none')
      }
      menuContent[i].classList.remove('d-none')
    })
    // 滑鼠移出時
    menuList[i].addEventListener('mouseleave', function () {
      tmp = menuContent[i]
    })
    menuContent[i].addEventListener('mouseleave', function () {
      menuContent[i].classList.add('d-none')
    })
  }
})

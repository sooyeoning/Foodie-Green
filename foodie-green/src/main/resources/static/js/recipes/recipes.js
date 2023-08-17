document.addEventListener('DOMContentLoaded', function() {
    const floatingButton = document.querySelector('.floating-button');
    const dropdownLayer = document.querySelector('.write-dropdown');

    floatingButton.addEventListener('click', function() {
        dropdownLayer.classList.toggle('active');
    });

    // 클릭 이외의 영역을 클릭하면 드롭다운 레이어 닫기
    window.addEventListener('click', function(event) {
        if (!floatingButton.contains(event.target)) {
            dropdownLayer.classList.remove('active');
        }
    });
});

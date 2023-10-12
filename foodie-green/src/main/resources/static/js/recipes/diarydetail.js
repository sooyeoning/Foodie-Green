document.addEventListener('DOMContentLoaded', function() {
    const floatingButton = document.querySelector('.floating-button');
    const dropdownLayer = document.querySelector('.write-dropdown');
    const likeButton = document.querySelector('.like-button');
    const deleteButton = document.getElementById('delete-button');
    const editButton = document.getElementById('edit-button');
    const diaryWriteButton = document.querySelector('a[href="/diarywrite"]');
    const recipesWriteButton = document.querySelector('a[href="/recipeswrite"]');
    const commentForm = document.getElementById('commentForm');

    console.log('isLoggedIn:', isLoggedIn);
    console.log('loggedInUserNickname:', loggedInUserNickname);
    console.log('writer:', writer);

    floatingButton.addEventListener('click', function() {
        dropdownLayer.classList.toggle('active');
    });

    document.addEventListener('click', function(event) {
        if (!floatingButton.contains(event.target)) {
            dropdownLayer.classList.remove('active');
        }
    });

    function redirectToLoginIfNotLoggedIn(event) {
        if (!isLoggedIn) {
            alert('로그인이 필요한 기능입니다.');
            window.location.href = '/login';
            event.preventDefault();
        }
    }

    diaryWriteButton.addEventListener('click', redirectToLoginIfNotLoggedIn);
    recipesWriteButton.addEventListener('click', redirectToLoginIfNotLoggedIn);

    if (isLoggedIn && loggedInUserNickname === writer) {
        deleteButton.style.display = 'inline-block';
        editButton.style.display = 'inline-block';
    }

    editButton.addEventListener('click', function() {
        window.location.href = `/editDiary/${diary_id}`;
    });

    deleteButton.addEventListener('click', function() {
        if (confirm('정말로 글을 삭제하시겠습니까?')) {
            const url = `/deleteDiary/${diary_id}`;
            fetch(url, {
                method: 'POST',
            })
            .then(response => response.text())
            .then(data => {
                if (data === "Success") {
                    window.location.href = '/diary';
                    alert('글이 삭제되었습니다.');
                } else {
                    alert('글 삭제에 실패하였습니다.');
                }
            })
            .catch(error => {
                console.error('An error occurred:', error);
            });
        }
    });

    likeButton.addEventListener('click', function() {
        if (!isLoggedIn) {
            alert('로그인이 필요한 기능입니다.');
            window.location.href = '/login';
            return;
        }

        const url = `/toggleLike/${diary_id}`;
        fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
        })
        .then(response => response.text())
        .then(data => {
            if (data === "Success") {
                window.location.reload();
            } else {
                // 실패 시 수행할 작업
            }
        })
        .catch(error => {
            console.error('An error occurred:', error);
        });
    });

    commentForm.addEventListener('submit', function(e) {
        e.preventDefault();

        if (!isLoggedIn) {
            alert('로그인이 필요한 기능입니다.');
            window.location.href = '/login';
            return;
        }

        const formData = new FormData(commentForm);
        fetch('/commentwrite', {
            method: 'POST',
            body: formData
        })
        .then(response => response.json())
        .then(data => {
            if (data.result === "Success") {
                alert('댓글이 추가되었습니다.');
                window.location.reload();
            } else {
                alert('댓글 추가에 실패하였습니다.');
            }
        })
        .catch(error => {
            console.error('An error occurred:', error);
        });
    });
});

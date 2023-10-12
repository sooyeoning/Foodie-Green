document.addEventListener('DOMContentLoaded', function() {
    const floatingButton = document.querySelector('.floating-button');
    const dropdownLayer = document.querySelector('.write-dropdown');
    const likeButton = document.querySelector('.like-button');
    const deleteButton = document.getElementById('delete-button');
    const editButton = document.getElementById('edit-button');
    const diaryWriteButton = document.querySelector('a[href="/diarywrite"]');
    const recipesWriteButton = document.querySelector('a[href="/recipeswrite"]');
    const commentForm = document.getElementById('commentForm');
    const commentDeleteButtons = document.querySelectorAll('.delete-comment-btn');

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
    commentDeleteButtons.forEach(button => {
        button.addEventListener('click', function(event) {
            // 사용자에게 댓글을 삭제할 것인지 물어봅니다.
            if (confirm('댓글을 삭제하시겠습니까?')) {
                // 데이터 속성에서 댓글 ID를 가져옵니다.
                const commentId = event.target.getAttribute('data-id');

                // DELETE 요청을 서버에 전송합니다.
                fetch(`/deleteComment/${commentId}`, {
                    method: 'DELETE',
                })
                .then(response => response.text())
                .then(data => {
                    if (data === "Success") {
                        alert('댓글이 삭제되었습니다.');
                        // 페이지를 새로고침하여 댓글이 삭제된 것을 반영합니다.
                        window.location.reload();
                    } else {
                        alert('댓글 삭제에 실패하였습니다.');
                    }
                })
                .catch(error => {
                    console.error('An error occurred:', error);
                });
            }
        });
    });
    
});

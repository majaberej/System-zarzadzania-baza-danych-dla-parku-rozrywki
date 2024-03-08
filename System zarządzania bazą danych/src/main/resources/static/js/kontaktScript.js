function copyEmail() {
            var copyText = "kontakt@energiolandia.pl";

            navigator.clipboard.writeText(copyText);

            Swal.fire({
                titleText: 'Sukces!',
                text: 'Skopiowano adres email do schowka.',
                icon: 'success',
                background: '#fbf7f4',
                showConfirmButton: false,
                timer: 1500
            });
        }

        function copyNumber() {
            var copyText = "623 786 124";

            navigator.clipboard.writeText(copyText);

            Swal.fire({
                titleText: 'Sukces!',
                text: 'Skopiowano numer telefonu do schowka.',
                icon: 'success',
                background: '#fbf7f4',
                showConfirmButton: false,
                timer: 1500
            });
        }
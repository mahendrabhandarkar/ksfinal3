@import gg.jte.Content

@param Content content

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My JTE Application</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>

@template.layout.header()

<div class="d-flex">
    @template.layout.sidebar()

    <main class="flex-grow-1 p-4">
        ${content}
    </main>
</div>

@template.layout.footer()

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/js/bootstrap.min.js"></script>
</body>
</html>
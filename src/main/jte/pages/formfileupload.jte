@import java.util.List

@param String username
@param String message
@param String filevar
@param List<String> filesvar

@template.layout.datatablemain(content = @`
<div class="bg-white shadow rounded p-4">
    <h1>File Upload Form!</h1>
    <p>Upload file greater than 20 MB.</p>

    @if (message.equals(""))
    <div>
        <h2>Flash Message: ${message}</h2>
    </div>
    @endif

    <div>
        <form method="POST" enctype="multipart/form-data" action="handleupload">
            <table class="table">
                <tr><td>File to upload:</td><td><input type="file" name="file" /></td></tr>
                <tr><td></td><td><input type="submit" value="Upload" /></td></tr>
            </table>
        </form>
    </div>

    <div>
        <ul>
            @for (String filevar : filesvar)
                <li><a href="download/${filevar}" alt="${filevar}" target="_blank">${filevar}</a></li>
            @endfor

        </ul>
    </div>

</div>
`)
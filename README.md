# Simple Virus Analyzer using Java and H2.

#### Notes

The `SQL` version of the database can be found from here.

The fully built `.jar` can be found from [here](https://www.youtube.com/redirect?v=4U_AAtMel94&redir_token=9TkcYTej7ZGj-nY11U1SC5k6yBB8MTUzMDE3NzE4M0AxNTMwMDkwNzgz&event=video_description&q=https%3A%2F%2Fdrive.google.com%2Fopen%3Fid%3D0B1g-HCHDlI3PSkpCOUE4bkpSSlk).

You need to migrate your SQL database to a H2 database using [Flyway](https://flywaydb.org/getstarted/firststeps/commandline). Since it weighs around 355MB it was decided not to include it into the repository.

However, when converting, you need to alter some lines of code in the original SQL file.

![Remove this line](docs/1.png "Remove this")
_Remove this line._

And remove all the `\'` and replace them with `.`

The converted file will look something like `xxxx.mv.db`. (Depending on your naming conventions) You'll need to rename it to `viruses.mv.db` or change the source code's DB URL to your database name.

### Usage

1. Clone the repository.
2. Adhere to *Notes* section.
3. Run the application. 



# LegendDialog

A beautiful custom dialog for android apps.

How to use?

Download the project and import it as module in the project. 
Don't forget to add it in dependencies as:

implementation project(':legendDialog')

Here is the code for dialog with two options:

TwoOptionsDialog dialog = new TwoOptionsDialog(this, getString(R.string.app_name),
                "Hello, how are you?", "Ok", "Cancel",
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
        dialog.setLogo(getResources().getDrawable(R.mipmap.ic_launcher_round));
        dialog.show();

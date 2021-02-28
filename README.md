# SnackBarMaker
Der SnackBarMaker kann genutzt werden für schnelle benutzerdefinierte SnackBars. Einfach den SnackBarMaker-Code kopieren.

## How to use

```JAVA
SnackBarMaker.get(ProfileAct.this)
  .setTextColor("#FFFFFF")
  .setBackgroundColor("#000000")
  .setMessage("Hello World!")
  .setHowLongInSeconds(3)
  .setIconLeftDrawable(R.drawable.ic_info_white_24)
  .setIconPaddingDp(8)
  .setActionText("back")
  .setAction(new View.OnClickListener() {
     @Override
        public void onClick(View v) {
        finish();
        }
     })
  .show(v);
```

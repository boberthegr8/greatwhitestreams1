# Building GWStreams on GitHub (no PC needed)

This builds your APK in the cloud. You only need a phone and a free GitHub account.

## One-time setup

1. **Sign in to GitHub** at https://github.com (you already have `boberthegr8`).

2. **Create a new repository**
   - Tap the **+** (top right) → **New repository**.
   - Name it `gwstreams` (or anything).
   - Set it **Private** (your panel code stays yours) or Public — either works.
   - Don't add a README/gitignore (the project already has them).
   - Tap **Create repository**.

3. **Upload the project files**
   - On the empty repo page, tap **uploading an existing file**.
   - Unzip `gwstreams.zip` first, then drag in **everything inside** the
     `gwstreams` folder (not the folder itself — its contents, so that
     `app/`, `gradlew`, `build.gradle.kts`, and `.github/` sit at the top level).
   - On a phone: use the GitHub mobile site or app to upload, or do this one
     time from any computer (a friend's, library, work) — after that you never
     need a PC again.
   - Tap **Commit changes**.

## Getting your APK

1. After uploading, go to the **Actions** tab of your repo.
2. You'll see a run called **Build GWStreams APK** start automatically
   (yellow dot = building, ~5 minutes). If it doesn't start, tap the workflow
   on the left, then **Run workflow**.
3. When it turns green ✓, tap into the run.
4. Scroll to **Artifacts** at the bottom → tap **GWStreams-debug-apk** to
   download a zip.
5. Unzip it on your phone → you get `app-debug.apk`.
6. Tap it to install. Android will ask to allow installing from this source —
   say yes. Done.

## Making changes later
Every time you edit a file in the repo and commit, GitHub rebuilds the APK
automatically. Just grab the new one from the Actions tab. No PC, ever.

## If a build fails
Open the failed run in the Actions tab and tap the red step to see the log.
Most first-time issues are a missing file from the upload — make sure the
`.github` folder and `gradlew` made it in. Send me the error and I'll sort it.

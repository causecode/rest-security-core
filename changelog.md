# ChangeLog

## [0.0.3] [12-10-2017]

### Fixed
1. Dependencies - changed compile dependencies to provided dependency for common dependencies which will be
 present in the installing app. (For ex - spring security core and spring security rest, json views etc.)

### Added
1. ####CircleCI configuration
    -  `.circleci/config.yml` for build automation using `CircleCI`.
    - `mavenCredsSetup.sh` for generating `gradle.properties` during the CircleCI build.

2. Added `asynchronous-mail` dependency in `build.gradle`.
    
### Changed
1. Upgraded `gradle-code-quality` version to `1.0.0` in `build.gradle`.
2. Updated `maven` server url in `build.gradle`.
3. Updated Gradle Wrapper version from 3.0 to 3.4.1 in `build.gradle`. 
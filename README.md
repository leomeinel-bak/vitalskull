<!-- PROJECT SHIELDS -->

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![Quality][quality-shield]][quality-url]

<!-- PROJECT LOGO -->
<!--suppress ALL -->
<br />
<p align="center">
  <a href="https://github.com/LeoMeinel/VitalSkull">
    <img src="images/logo.png" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">VitalSkull</h3>

  <p align="center">
    Get your own skull on Spigot and Paper
    <br />
    <a href="https://github.com/LeoMeinel/VitalSkull"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/LeoMeinel/VitalSkull">View Demo</a>
    ·
    <a href="https://github.com/LeoMeinel/VitalSkull/issues">Report Bug</a>
    ·
    <a href="https://github.com/LeoMeinel/VitalSkull/issues">Request Feature</a>
  </p>

<!-- ABOUT THE PROJECT -->

## About The Project

### Description

VitalSkull is a Plugin that gives players the ability to get their own skull.

This plugin is perfect for any server wanting their players to be able to display or trade heads.

### Features

- Get your own skull

### Built With

- [Gradle 7](https://docs.gradle.org/7.5.1/release-notes.html)
- [OpenJDK 17](https://openjdk.java.net/projects/jdk/17/)

<!-- GETTING STARTED -->

## Getting Started

To get the plugin running on your server follow these simple steps.

### Commands and Permissions

1. Permission: `vitalskull.skull`

- Command: `/skull`
- Description: Get your own skull

2. Permission: `vitalskull.cooldown.bypass`

- Description: Bypass cooldown

### Configuration - config.yml

```yaml
# Command cool-down
cooldown:
  enabled: true
  # time in s
  time: 60
```

### Configuration - messages.yml

```yaml
cmd: "&fUsage: &b/skull"
no-perms: "&cYou don't have enough permissions!"
player-only: "&cThis command can only be executed by players!"
cooldown-active: "&cYou can't use that command for another &b%time-left% &cseconds!"
```

<!-- ROADMAP -->

## Roadmap

See the [open issues](https://github.com/LeoMeinel/VitalFly/issues) for a list of proposed features (and known
issues).

<!-- CONTRIBUTING -->

## Contributing

Contributions are what make the open source community such an amazing place to be, learn, inspire, and create. Any
contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<!-- LICENSE -->

## License

Distributed under the GNU General Public License v3.0. See `LICENSE` for more information.

<!-- CONTACT -->

## Contact

Leopold Meinel - [leo@meinel.dev](mailto:leo@meinel.dev) - eMail

Project Link - [VitalSkull](https://github.com/LeoMeinel/VitalSkull) - GitHub

<!-- ACKNOWLEDGEMENTS -->

### Acknowledgements

- [README.md - othneildrew](https://github.com/othneildrew/Best-README-Template)

<!-- MARKDOWN LINKS & IMAGES -->

[contributors-shield]: https://img.shields.io/github/contributors-anon/LeoMeinel/VitalSkull?style=for-the-badge
[contributors-url]: https://github.com/LeoMeinel/VitalSkull/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/LeoMeinel/VitalSkull?label=Forks&style=for-the-badge
[forks-url]: https://github.com/LeoMeinel/VitalSkull/network/members
[stars-shield]: https://img.shields.io/github/stars/LeoMeinel/VitalSkull?style=for-the-badge
[stars-url]: https://github.com/LeoMeinel/VitalSkull/stargazers
[issues-shield]: https://img.shields.io/github/issues/LeoMeinel/VitalSkull?style=for-the-badge
[issues-url]: https://github.com/LeoMeinel/VitalSkull/issues
[license-shield]: https://img.shields.io/github/license/LeoMeinel/VitalSkull?style=for-the-badge
[license-url]: https://github.com/LeoMeinel/VitalSkull/blob/main/LICENSE
[quality-shield]: https://img.shields.io/codefactor/grade/github/LeoMeinel/VitalSkull?style=for-the-badge
[quality-url]: https://www.codefactor.io/repository/github/LeoMeinel/VitalSkull
